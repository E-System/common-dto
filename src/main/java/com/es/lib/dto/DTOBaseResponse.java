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

import java.io.Serializable;

/**
 * Base response class with data and environment
 *
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
