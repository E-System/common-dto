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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

/**
 * Response class with pager
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 16.08.2021
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(description = "Pager response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPagerResponse<T> extends DTOResponse<Collection<T>> {

    @ApiModelProperty(notes = "Pager data", position = 2)
    protected DTOPager<T> pager;
    @ApiModelProperty(notes = "Totals data", position = 3)
    protected Object totals;

    public DTOPagerResponse(DTOPager<T> pager) {
        this(pager, null);
    }

    public DTOPagerResponse(DTOPager<T> pager, Object totals) {
        super(pager.getValues());
        this.pager = new DTOPager<>(
            pager.getPage(),
            pager.getTotal(),
            pager.getPageSize(),
            null,
            pager.getNumberOfPages(),
            pager.getPages()
        );
        this.totals = totals;
    }
}
