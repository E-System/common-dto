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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Request process result")
public class DTOResult implements Serializable {

    /**
     * Успех
     */
    @Deprecated
    public static final short OK = 200;
    //-------------------------------------------------------
    /**
     * Ошибка обработки
     */
    @Deprecated
    public static final short BAD_REQUEST = 400;
    /**
     * Необходима авторизация
     */
    @Deprecated
    public static final short UNAUTHORIZED = 401;
    /**
     * Доступ запрещен
     */
    @Deprecated
    public static final short FORBIDDEN = 403;
    /**
     * Ошибка валидации входных данных
     */
    @Deprecated
    public static final short UNPROCESSABLE_ENTITY = 422;
    //-------------------------------------------------------
    /**
     * Внутреняя ошибка сервера
     */
    @Deprecated
    public static final short INTERNAL_SERVER_ERROR = 500;
    /**
     * Системная ошибка сервера
     */
    @Deprecated
    public static final short SYSTEM_ERROR = 500;
    //-------------------------------------------------------
    @ApiObjectField(description = "Code", allowedvalues = {"200", "400", "401", "403", "422", "500"}, order = 0)
    @ApiModelProperty(notes = "Code", allowableValues = "200, 400, 401, 403, 422, 500", position = 0)
    @Deprecated
    private short code;
    @ApiObjectField(description = "Simple message information", order = 1)
    @ApiModelProperty(notes = "Simple message information", position = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
    @ApiObjectField(description = "Error code", order = 2)
    @ApiModelProperty(notes = "Error code", position = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @ApiObjectField(description = "Localized message information", order = 3)
    @ApiModelProperty(notes = "Localized message information", position = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DTOLocalizeMessage localizeMessage;

    public DTOResult() { }

    @Deprecated
    public DTOResult(short code) {
        this.code = code;
    }

    @Deprecated
    public DTOResult(short code, String msg) {
        this(code);
        this.msg = msg;
    }

    @Deprecated
    public DTOResult(short code, String msg, String errorCode) {
        this(code, msg);
        this.errorCode = errorCode;
    }

    @Deprecated
    public DTOResult(short code, DTOLocalizeMessage localizeMessage) {
        this.code = code;
        this.localizeMessage = localizeMessage;
        if (localizeMessage != null) {
            this.errorCode = localizeMessage.getCode();
        }
    }

    @Deprecated
    public DTOResult(short code, DTOLocalizeMessage localizeMessage, String msg) {
        this(code, localizeMessage);
        this.msg = msg;
    }

    @Deprecated
    public DTOResult(short code, DTOLocalizeMessage localizeMessage, String msg, String errorCode) {
        this(code, localizeMessage, msg);
        this.errorCode = errorCode;

    }

    public DTOResult(String msg) {
        this.msg = msg;
    }

    public DTOResult(String msg, String errorCode) {
        this(msg);
        this.errorCode = errorCode;
    }

    public DTOResult(DTOLocalizeMessage localizeMessage) {
        this.localizeMessage = localizeMessage;
        if (localizeMessage != null) {
            this.errorCode = localizeMessage.getCode();
        }
    }

    public DTOResult(DTOLocalizeMessage localizeMessage, String msg) {
        this(localizeMessage);
        this.msg = msg;
    }

    public DTOResult(DTOLocalizeMessage localizeMessage, String msg, String errorCode) {
        this(localizeMessage, msg);
        this.errorCode = errorCode;

    }

    @Deprecated
    public short getCode() {
        return code;
    }

    @Deprecated
    public void setCode(short code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public DTOLocalizeMessage getLocalizeMessage() {
        return localizeMessage;
    }

    public void setLocalizeMessage(DTOLocalizeMessage localizeMessage) {
        this.localizeMessage = localizeMessage;
    }

    @Deprecated
    @JsonIgnore
    public boolean isOk() {
        return getCode() == OK;
    }

    @Deprecated
    @JsonIgnore
    public boolean isError() {
        return getCode() != OK;
    }

    @Override
    public String toString() {
        return "DTOResult{" +
               "code=" + code +
               ", msg='" + msg + '\'' +
               ", errorCode='" + errorCode + '\'' +
               ", localizeMessage=" + localizeMessage +
               '}';
    }
}
