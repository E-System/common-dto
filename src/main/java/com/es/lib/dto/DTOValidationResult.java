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

import com.es.lib.dto.validation.DTOValidationField;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

/**
 * Request validation information with message and type
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 25.03.19
 */
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "Request validation result")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOValidationResult extends DTOResult {

    @ApiModelProperty(notes = "Request validation information", position = 2)
    private Collection<DTOValidationField> fields;

    public DTOValidationResult(String code, String msg, Collection<DTOValidationField> fields) {
        super(code, msg);
        this.fields = fields;
    }
}
