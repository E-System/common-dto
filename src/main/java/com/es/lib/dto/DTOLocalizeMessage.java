/*
 * Copyright (c) Extended System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Extended System team (https://ext-system.com), 2015
 */

package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
import java.util.Collection;

/**
 * Сообщение(для локализации). Содержит код сообщения и аргументы для формирования сообщения
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
