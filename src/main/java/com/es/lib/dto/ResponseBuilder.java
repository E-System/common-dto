/*
 * Copyright 2016 E-System LLC
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
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

    public ResponseBuilder<T> ok() {
        return code(DTOResult.OK);
    }

    public ResponseBuilder<T> badRequest() {
        return code(DTOResult.BAD_REQUEST);
    }

    public ResponseBuilder<T> unauthorized() {
        return code(DTOResult.UNAUTHORIZED);
    }

    public ResponseBuilder<T> forbidden() {
        return code(DTOResult.FORBIDDEN);
    }

    public ResponseBuilder<T> unprocessableEntity() {
        return code(DTOResult.UNPROCESSABLE_ENTITY);
    }

    public ResponseBuilder<T> internalServerError() {
        return code(DTOResult.INTERNAL_SERVER_ERROR);
    }

    public ResponseBuilder<T> systemError() {
        return code(DTOResult.SYSTEM_ERROR);
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
