package com.github.tablesheep233.text.translate.api;

import com.github.tablesheep233.text.translate.param.TextTranslateParam;
import com.github.tablesheep233.text.translate.service.TextTranslateService;
import com.github.tablesheep233.text.translate.vo.TextTranslateResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("text-translate")
public class TextTranslateApi {

    private final TextTranslateService textTranslateService;

    @PostMapping
    public TextTranslateResultVO translate(@RequestBody @Validated TextTranslateParam textTranslateParam) {
        return textTranslateService.translate(textTranslateParam.getSourceText(), textTranslateParam.getSourceLanguage(), textTranslateParam.getTargetLanguages());
    }
}
