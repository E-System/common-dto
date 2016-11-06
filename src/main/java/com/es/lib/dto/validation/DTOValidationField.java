/*
 * Copyright (c) Extended System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Extended System team (https://ext-system.com), 2015
 */

package com.es.lib.dto.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Поле с информацией о валидации
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DTOValidationField implements Serializable {

    private String name;
    private String msg;

    public DTOValidationField() {
    }

    public DTOValidationField(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ValidationField [" +
               "name='" + name + "'" +
               ", msg='" + msg + "'" +
               ']';
    }
}
