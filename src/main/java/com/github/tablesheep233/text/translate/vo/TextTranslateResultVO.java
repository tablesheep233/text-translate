package com.github.tablesheep233.text.translate.vo;

import com.github.tablesheep233.text.translate.constant.LanguageEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * The type Text translate result vo.
 *
 * @author tablesheep
 */
@Data
public class TextTranslateResultVO implements Serializable {

    private String sourceText;

    private LanguageEnum sourceLanguage;

    private List<Target> targets;

    /**
     * The type Target.
     *
     * @author tablesheep
     */
    @Data
    public static class Target implements Serializable {

        public Target(String targetText, LanguageEnum targetLanguage) {
            this.targetText = targetText;
            this.targetLanguage = targetLanguage;
        }

        private String targetText;

        private LanguageEnum targetLanguage;
    }

}
