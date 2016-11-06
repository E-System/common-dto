/*
 * Copyright (c) Extended System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Extended System team (https://ext-system.com), 2015
 */

package com.es.lib.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
public class DTOPager<T> implements Serializable {

    private int page;
    private long total;
    private int pageSize;
    private Collection<T> values;
    private int numberOfPages;
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
