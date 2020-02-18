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

package com.es.lib.dto.compat;

import com.es.lib.dto.DTOEnvironmentalResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Response with only data
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@Getter
@NoArgsConstructor
@ApiModel(description = "Response with data (compat)")
public class DTOResponseCompat<T> extends DTOEnvironmentalResponse<T, Object> {

    @ApiModelProperty(notes = "Result compat", position = 0)
    private DTOResultCompat result;
    @ApiModelProperty(notes = "Error code", position = 1)
    private String code;
    @ApiModelProperty(notes = "Error message", position = 2)
    private String msg;

    public DTOResponseCompat(T data) {
        super(data);
        this.result = new DTOResultCompat(200);
    }

    public DTOResponseCompat(DTOResultCompat result) {
        super(null);
        this.result = result;
    }
}
