package com.github.tablesheep233.text.translate.service.impl;


import com.github.tablesheep233.text.translate.config.TranslateProperties;
import com.github.tablesheep233.text.translate.constant.LanguageEnum;
import com.github.tablesheep233.text.translate.service.TextTranslateService;
import com.github.tablesheep233.text.translate.vo.TextTranslateResultVO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * implement TextTranslateService based on <a href="https://niutrans.com/">小牛翻译</a>
 *
 * @author tablesheep
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NiutransTextTranslateService implements TextTranslateService {


    private static final String NIU_ZH_HANT = "cht";
    private static final String NIU_IN = "id";
    private static final String NIU_IW = "he";

    private static final Map<LanguageEnum, String> NIU_LANGUAGE_MAP;

    static {
        NIU_LANGUAGE_MAP = new HashMap<>();
        NIU_LANGUAGE_MAP.put(LanguageEnum.ZH_HANT, NIU_ZH_HANT);
        NIU_LANGUAGE_MAP.put(LanguageEnum.IN, NIU_IN);
        NIU_LANGUAGE_MAP.put(LanguageEnum.IW, NIU_IW);
    }

    private final TranslateProperties translateProperties;

    private final RestTemplate restTemplate;


    @Override
    public TextTranslateResultVO translate(String sourceText, LanguageEnum sourceLanguage, List<LanguageEnum> targetLanguages) {
        TextTranslateResultVO resultVO = new TextTranslateResultVO();
        List<TextTranslateResultVO.Target> targets = new ArrayList<>(targetLanguages.size());

        for (LanguageEnum targetLanguage : targetLanguages) {
            String targetText = translate(sourceText, sourceLanguage, targetLanguage);
            if (StringUtils.hasText(targetText)) {
                targets.add(new TextTranslateResultVO.Target(targetText, targetLanguage));
            } else {
                targets.add(new TextTranslateResultVO.Target(null, targetLanguage));
            }
        }

        resultVO.setTargets(targets);
        resultVO.setSourceText(sourceText);
        resultVO.setSourceLanguage(sourceLanguage);
        return resultVO;
    }

    @Override
    public String adaptLanguage(LanguageEnum languageEnum) {
        if (NIU_LANGUAGE_MAP.containsKey(languageEnum)) {
            return NIU_LANGUAGE_MAP.get(languageEnum);
        }
        return TextTranslateService.super.adaptLanguage(languageEnum);
    }

    @SneakyThrows
    private String translate(String sourceText, LanguageEnum sourceLanguage, LanguageEnum targetLanguage) {
        String source = adaptLanguage(sourceLanguage);
        String target = adaptLanguage(targetLanguage);

        NiuTransResponse response = restTemplate.postForObject(translateProperties.getNiuTrans().getUrl(),
                new NiuTransRequest(source, target, translateProperties.getNiuTrans().getKey(), sourceText), NiuTransResponse.class);
        TimeUnit.MILLISECONDS.sleep(500);
        if (Objects.isNull(response) || StringUtils.hasText(response.getError_code())) {
            log.error("niutrans response error, response info : {}", response);
            return null;
        }
        return response.getTgt_text();
    }

    @Setter
    @Getter
    private static final class NiuTransRequest implements Serializable {

        public NiuTransRequest(String from, String to, String apikey, String src_text) {
            this.from = from;
            this.to = to;
            this.apikey = apikey;
            this.src_text = src_text;
        }

        private String from;
        private String to;
        private String apikey;
        private String src_text;
    }

    @Data
    private static final class NiuTransResponse implements Serializable {
        private String from;
        private String to;
        private String src_text;
        private String tgt_text;
        private String error_code;
        private String error_msg;
    }
}
