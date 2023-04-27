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

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Pager
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Pager")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPager<T> implements Serializable {

    @Schema(description = "Current page")
    private int page;
    @Schema(description = "Total elements count")
    private long total;
    @Schema(description = "Count of elements on page")
    private int pageSize;
    @Schema(description = "Page elements")
    private Collection<T> values;
    @Schema(description = "Total pages count")
    private int numberOfPages;
    @Schema(description = "Page numbers")
    private Collection<Integer> pages;

    public DTOPager(int page, long total, int pageSize, Collection<T> values) {
        this.page = page;
        this.total = total;
        this.pageSize = pageSize;
        this.pages = new ArrayList<>();
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
