/*
 * Copyright (c) E-System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2015
 */

package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Результат выполнения
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
public class DTOResult implements Serializable {

    /**
     * Успех
     */
    public static final short OK = 200;
    //-------------------------------------------------------
    /**
     * Ошибка обработки
     */
    public static final short BAD_REQUEST = 400;
    /**
     * Ошибка авторизации
     */
    public static final short UNAUTHORIZED = 401;
    /**
     * Ошибка валидации входных данных
     */
    public static final short UNPROCESSABLE_ENTITY = 422;
    //-------------------------------------------------------
    /**
     * Внутреняя ошибка сервера
     */
    public static final short INTERNAL_SERVER_ERROR = 500;
    /**
     * Системная ошибка сервера
     */
    public static final short SYSTEM_ERROR = 500;
    //-------------------------------------------------------
    private short code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DTOLocalizeMessage localizeMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;

    public DTOResult() {
    }

    public DTOResult(short code) {
        this.code = code;
    }


    public DTOResult(short code, DTOLocalizeMessage localizeMessage) {
        this.code = code;
        this.localizeMessage = localizeMessage;
    }

    public DTOResult(short code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DTOResult(short code, DTOLocalizeMessage localizeMessage, String msg) {
        this.code = code;
        this.localizeMessage = localizeMessage;
        this.msg = msg;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public DTOLocalizeMessage getLocalizeMessage() {
        return localizeMessage;
    }

    public void setLocalizeMessage(DTOLocalizeMessage localizeMessage) {
        this.localizeMessage = localizeMessage;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isOk() {
        return getCode() == OK;
    }

    @JsonIgnore
    public boolean isError() {
        return getCode() != OK;
    }

    @Override
    public String toString() {
        return "DTOResult [" +
               "code=" + code +
               ", localizeMessage=" + localizeMessage +
               ", msg='" + msg + "'" +
               ']';
    }
}
