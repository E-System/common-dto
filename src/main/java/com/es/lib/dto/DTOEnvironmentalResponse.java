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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

/**
 * Environmental response class with data and environment
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@ApiObject(name = "DTOEnvironmentalResponse", description = "Environmental response class")
@ApiModel(description = "Environmental response class")
public class DTOEnvironmentalResponse<T, E> implements Serializable {

    @ApiObjectField(description = "Result information", order = 0)
    @ApiModelProperty(notes = "Result information", position = 0)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected DTOResult result;
    @ApiObjectField(description = "Data object", order = 1)
    @ApiModelProperty(notes = "Data object", position = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected T data;
    @ApiObjectField(description = "Environment object", order = 2)
    @ApiModelProperty(notes = "Environment object", position = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected E env;

    @Deprecated
    public DTOEnvironmentalResponse() {
        result = new DTOResult(DTOResult.BAD_REQUEST);
    }

    @Deprecated
    private DTOEnvironmentalResponse(DTOResult result) {
        this.result = result;
    }

    @Deprecated
    public DTOEnvironmentalResponse(DTOResult result, T data) {
        this(result);
        this.data = data;
    }

    public DTOEnvironmentalResponse(T data) {
        this.data = data;
    }

    @Deprecated
    public DTOResult getResult() {
        return result;
    }

    @Deprecated
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
        return "DTOEnvironmentalResponse{" +
               "result=" + result +
               ", data=" + data +
               ", env=" + env +
               '}';
    }
}
