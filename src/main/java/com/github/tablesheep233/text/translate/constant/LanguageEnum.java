package com.github.tablesheep233.text.translate.constant;

/**
 * The enum Language enum.
 *
 * @author tablesheep
 */
public enum LanguageEnum implements IStringEnum {

    /**
     * Zh language enum.
     */
    ZH("zh", "中文"),
    /**
     * Ko language enum.
     */
    KO("ko", "韩语"),
    /**
     * Ja language enum.
     */
    JA("ja", "日语"),
    /**
     * En language enum.
     */
    EN("en", "英语"),
    /**
     * Ru language enum.
     */
    RU("ru", "俄语"),
    /**
     * Ar language enum.
     */
    AR("ar", "阿拉伯语"),
    /**
     * De language enum.
     */
    DE("de", "德语"),
    /**
     * Es language enum.
     */
    ES("es", "西班牙语"),
    /**
     * In language enum.
     */
    IN("in", "印度尼西亚语"),
    /**
     * It language enum.
     */
    IT("it", "意大利语"),
    /**
     * Pt language enum.
     */
    PT("pt", "葡萄牙语"),
    /**
     * Fr language enum.
     */
    FR("fr", "法语"),
    /**
     * Pl language enum.
     */
    PL("pl", "波兰语"),
    /**
     * Tr language enum.
     */
    TR("tr", "土耳其语"),
    /**
     * Cs language enum.
     */
    CS("cs", "捷克语"),
    /**
     * Ms language enum.
     */
    MS("ms", "马来语"),
    /**
     * Zh hant language enum.
     */
    ZH_HANT("zh_hant", "中文繁体"),
    /**
     * Nl language enum.
     */
    NL("nl", "荷兰语"),
    /**
     * Iw language enum.
     */
    IW("iw", "现代希伯来语"),
    /**
     * Fa language enum.
     */
    FA("fa", "波斯语"),
    /**
     * El language enum.
     */
    EL("el", "现代希腊语"),
    /**
     * Th language enum.
     */
    TH("th", "泰语"),
    /**
     * Vi language enum.
     */
    VI("vi", "越南语"),
    /**
     * Fil language enum.
     */
    FIL("fil", "菲律宾语"),
    /**
     * Sv language enum.
     */
    SV("sv", "瑞典语");

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    LanguageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
