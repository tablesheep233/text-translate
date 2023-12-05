package com.github.tablesheep233.text.translate.param;

import com.github.tablesheep233.text.translate.constant.LanguageEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * The type Text translate param.
 *
 * @author tablesheep
 */
@Data
public class TextTranslateParam implements Serializable {

    @NotNull
    private String sourceText;

    private LanguageEnum sourceLanguage = LanguageEnum.ZH;

    @NotNull
    @Size(min = 1)
    private List<LanguageEnum> targetLanguages;
}
