package com.es.lib.dto;

import java.util.Arrays;
import java.util.Collection;

/**
 * Request param names
 */
public interface IRequestParams {

    /**
     * Request param name for page number
     */
    String PAGE = "page";
    /**
     * Request param name for limit
     */
    String LIMIT = "limit";
    /**
     * Request param name for last requested identifier
     */
    String LAST = "last";
    /**
     * Params for pager
     */
    Collection<String> ForPager = Arrays.asList(PAGE, LIMIT);
    /**
     * Params for bunch by last identifier
     */
    Collection<String> ForBunch = Arrays.asList(LAST, LIMIT);
}
