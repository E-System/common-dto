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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

/**
 * Execution result with code, localized message, simple message
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@ApiObject(name = "DTOResult", description = "Request process result")
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
     * Необходима авторизация
     */
    public static final short UNAUTHORIZED = 401;
    /**
     * Доступ запрещен
     */
    public static final short FORBIDDEN = 403;
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
    @ApiObjectField(description = "Code", allowedvalues = {"200", "400", "401", "403", "422", "500"}, order = 0)
    private short code;
    @ApiObjectField(description = "Simple message information", order = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
    @ApiObjectField(description = "Message code", order = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msgCode;
    @ApiObjectField(description = "Localized message information", order = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DTOLocalizeMessage localizeMessage;

    public DTOResult() { }

    public DTOResult(short code) {
        this.code = code;
    }


    public DTOResult(short code, String msg) {
        this(code);
        this.msg = msg;
    }

    public DTOResult(short code, String msg, String msgCode) {
        this(code, msg);
        this.msgCode = msgCode;
    }

    public DTOResult(short code, DTOLocalizeMessage localizeMessage) {
        this.code = code;
        this.localizeMessage = localizeMessage;
        if (localizeMessage != null) {
            this.msgCode = localizeMessage.getCode();
        }
    }

    public DTOResult(short code, DTOLocalizeMessage localizeMessage, String msg) {
        this(code, localizeMessage);
        this.msg = msg;
    }

    public DTOResult(short code, DTOLocalizeMessage localizeMessage, String msg, String msgCode) {
        this(code, localizeMessage, msg);
        this.msgCode = msgCode;

    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public DTOLocalizeMessage getLocalizeMessage() {
        return localizeMessage;
    }

    public void setLocalizeMessage(DTOLocalizeMessage localizeMessage) {
        this.localizeMessage = localizeMessage;
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
        return "DTOResult{" +
               "code=" + code +
               ", msg='" + msg + '\'' +
               ", msgCode='" + msgCode + '\'' +
               ", localizeMessage=" + localizeMessage +
               '}';
    }
}
