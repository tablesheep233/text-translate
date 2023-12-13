package com.github.tablesheep233.text.translate.constant;

/**
 * The interface Enum.
 *
 * @param <E>    the type parameter
 * @param <C> the type parameter
 * @author tablesheep
 */
public interface IEnum<E extends Enum<?>, C> {

    /**
     * Gets message.
     *
     * @return the message
     */
    String getMessage();

    /**
     * Gets code.
     *
     * @return the code
     */
    C getCode();

    /**
     * Name string.
     *
     * @return the string
     */
    String name();
}
