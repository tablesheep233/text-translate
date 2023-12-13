package com.github.tablesheep233.text.translate.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The type Translate properties.
 *
 * @author tablesheep
 */
@Data
@Validated
@ConfigurationProperties(prefix = "translate")
public class TranslateProperties {

    @NotNull
    private TranslateType type;

    private NiuTrans niuTrans;

    /**
     * The enum Translate type.
     *
     * @author tablesheep
     */
    public enum TranslateType {
        /**
         * Niu trans translate type.
         */
        NIU_TRANS
    }

    /**
     * The type Niu trans.
     *
     * @author tablesheep
     */
    @Data
    public static class NiuTrans {
        private String url = "https://api.niutrans.com/NiuTransServer/translation";

        @NotBlank
        private String key;
    }


}
