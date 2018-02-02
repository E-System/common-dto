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

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
import java.util.Collection;

/**
 * Message(for localization). Содержит код сообщения и аргументы для формирования сообщения
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
public class DTOLocalizeMessage {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<String> args;

    public DTOLocalizeMessage(String code) {
        this.code = code;
    }

    public DTOLocalizeMessage(String code, Collection<String> args) {
        this.code = code;
        this.args = args;
    }

    public DTOLocalizeMessage(String code, String... args) {
        this.code = code;
        this.args = args != null ? Arrays.asList(args) : null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<String> getArgs() {
        return args;
    }

    public void setArgs(Collection<String> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "DTOLocalizeMessage [" +
               "code='" + code + "'" +
               ", args=" + args +
               ']';
    }
}
