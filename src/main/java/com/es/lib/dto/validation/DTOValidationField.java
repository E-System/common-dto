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

/**
 * Field with validation information
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "DTOValidationField", description = "Validation field information")
@ApiModel(description = "Validation field information")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DTOValidationField implements Serializable {

    @ApiObjectField(description = "Name", order = 0)
    @ApiModelProperty(notes = "Name", position = 0)
    private String name;
    @ApiObjectField(description = "Message", order = 1)
    @ApiModelProperty(notes = "Message", position = 1)
    private String msg;
}
