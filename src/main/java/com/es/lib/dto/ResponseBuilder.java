/*
 * Copyright (c) E-System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2015
 */

package com.es.lib.dto;

import java.util.Arrays;
import java.util.Collection;

/**
 * Билдер ответа
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
public class ResponseBuilder<T> {

    private short code;
    private String messageCode;
    private Collection<String> args;
    private String message;
    private T data;

    public ResponseBuilder() {
        this.code = DTOResult.BAD_REQUEST;
    }

    public ResponseBuilder(short code) {
        this.code = code;
    }

    public ResponseBuilder<T> code(short code) {
        this.code = code;
        return this;
    }

    public ResponseBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder<T> localizedMessage(String messageCode) {
        this.messageCode = messageCode;
        return this;
    }

    public ResponseBuilder<T> localizedMessage(String messageCode, Collection<String> args) {
        this.messageCode = messageCode;
        this.args = args;
        return this;
    }

    public ResponseBuilder<T> localizedMessage(String messageCode, String... args) {
        this.messageCode = messageCode;
        this.args = args != null ? Arrays.asList(args) : null;
        return this;
    }

    public ResponseBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public DTOResponse<T> build() {
        DTOLocalizeMessage dtoLocalizeMessage =
                messageCode != null ?
                        new DTOLocalizeMessage(
                                messageCode,
                                args
                        ) : null;
        return new DTOResponse<>(
                new DTOResult(
                        code,
                        dtoLocalizeMessage,
                        message
                ),
                data
        );
    }

}
