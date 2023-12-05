package com.github.tablesheep233.text.translate.service;

import com.github.tablesheep233.text.translate.constant.LanguageEnum;
import com.github.tablesheep233.text.translate.vo.TextTranslateResultVO;

import java.util.List;

/**
 * The interface Text translate service.
 *
 * @author tablesheep
 */
public interface TextTranslateService {


    /**
     * Translate text translate result vo.
     *
     * @param sourceText      the source text
     * @param sourceLanguage  the source language
     * @param targetLanguages the target languages
     * @return the text translate result vo
     */
    TextTranslateResultVO translate(String sourceText, LanguageEnum sourceLanguage, List<LanguageEnum> targetLanguages);

    /**
     * Adapt language string.
     *
     * @param languageEnum the language enum
     * @return the string
     */
    default String adaptLanguage(LanguageEnum languageEnum) {
        return languageEnum.getCode();
    }
}
