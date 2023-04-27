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

package com.eslibs.dto;

import com.eslibs.dto.validation.DTOValidationField;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Request validation result")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOValidationResult extends DTOResult {

    @Schema(description = "Request validation information")
    private Collection<DTOValidationField> fields;

    public DTOValidationResult(String code, String msg, Collection<DTOValidationField> fields) {
        super(code, msg);
        this.fields = fields;
    }
}
