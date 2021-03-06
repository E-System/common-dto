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

package com.es.lib.dto.validation;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.Collection;

/**
 * Form validation information with message and type
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "DTOValidationStatus", description = "Form validation information")
@ApiModel(description = "Form validation information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOValidationStatus implements Serializable {

    @ApiObjectField(description = "Message type", order = 0)
    @ApiModelProperty(notes = "Message type", position = 0)
    private Type type;
    @ApiObjectField(description = "Form fields information", order = 1)
    @ApiModelProperty(notes = "Form fields information", position = 1)
    private Collection<DTOValidationField> fields;

    public DTOValidationStatus(Collection<DTOValidationField> fields) {
        this.fields = fields;
    }

    public enum Type {

        Info,
        Warn,
        Error,
        Fatal
    }
}
