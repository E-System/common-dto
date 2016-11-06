/*
 * Copyright (c) Extended System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Extended System team (https://ext-system.com), 2015
 */

package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
public class DTOBaseResponse<T, E> implements Serializable {

    protected DTOResult result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected E env;

    public DTOBaseResponse() {
        result = new DTOResult(DTOResult.BAD_REQUEST);
    }

    private DTOBaseResponse(DTOResult result) {
        this.result = result;
    }

    public DTOBaseResponse(DTOResult result, T data) {
        this(result);
        this.data = data;
    }

    public DTOResult getResult() {
        return result;
    }

    public void setResult(DTOResult result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public E getEnv() {
        return env;
    }

    public void setEnv(E env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "DTOBaseResponse{" +
               "result=" + result +
               ", data=" + data +
               ", env=" + env +
               '}';
    }
}
