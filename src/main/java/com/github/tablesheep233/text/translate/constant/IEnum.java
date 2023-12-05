package com.github.tablesheep233.text.translate.constant;

public interface IEnum<E extends Enum<?>, CODE> {

    String getMessage();

    CODE getCode();
}
