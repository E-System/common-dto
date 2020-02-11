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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Pager
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(description = "Pager")
public class DTOPager<T> implements Serializable {

    @ApiModelProperty(notes = "Current page", position = 0)
    private int page;
    @ApiModelProperty(notes = "Total elements count", position = 1)
    private long total;
    @ApiModelProperty(notes = "Count of elements on page", position = 2)
    private int pageSize;
    @ApiModelProperty(notes = "Page elements", position = 3)
    private Collection<T> values;
    @ApiModelProperty(notes = "Total pages count", position = 4)
    private int numberOfPages;
    @ApiModelProperty(notes = "Page numbers", position = 5)
    private Collection<Integer> pages;

    public DTOPager(int page, long total, int pageSize, Collection<T> values) {
        this.page = page;
        this.total = total;
        this.pageSize = pageSize;
        this.pages = new LinkedList<>();
        this.values = values;
        update();
    }

    private void update() {
        numberOfPages = (int) (total / pageSize + (total % pageSize > 0 ? 1 : 0));
        if (numberOfPages > 1) {
            int from, to;
            if (numberOfPages <= 8) {
                from = 1;
                to = numberOfPages;
            } else {
                int currentPage = page;
                from = currentPage - 3;
                if (from <= 0) {
                    from = 1;
                }
                to = from + 7;
                if (to > numberOfPages) {
                    to = numberOfPages;
                    from = to - 7;
                }
            }
            if (from > 1) {
                pages.add(1);
            }
            if (from > 2) {
                pages.add(-1);
            }
            for (int i = from; i <= to; ++i) {
                pages.add(i);
            }
            if (to < numberOfPages - 1) {
                pages.add(-1);
            }
            if (to < numberOfPages) {
                pages.add(numberOfPages);
            }
        }
    }
}
