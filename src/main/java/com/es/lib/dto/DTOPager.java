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

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Pager
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@ApiObject(name = "DTOPager", description = "Pager")
public class DTOPager<T> implements Serializable {

    @ApiObjectField(description = "Current page", order = 0)
    private int page;
    @ApiObjectField(description = "Total elements count", order = 1)
    private long total;
    @ApiObjectField(description = "Count of elements on page", order = 2)
    private int pageSize;
    @ApiObjectField(description = "Page elements", order = 3)
    private Collection<T> values;
    @ApiObjectField(description = "Total pages count", order = 4)
    private int numberOfPages;
    @ApiObjectField(description = "Page numbers", order = 5)
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Collection<T> getValues() {
        return values;
    }

    public void setValues(Collection<T> values) {
        this.values = values;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Collection<Integer> getPages() {
        return pages;
    }

    public void setPages(Collection<Integer> pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "DTOPager [" +
               "page=" + page +
               ", total=" + total +
               ", pageSize=" + pageSize +
               ", values=" + values +
               ", numberOfPages=" + numberOfPages +
               ", pages=" + pages +
               ']';
    }
}
