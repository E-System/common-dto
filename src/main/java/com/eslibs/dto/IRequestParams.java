package com.eslibs.dto;

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
     * Request param name for offset
     */
    String OFFSET = "offset";
    /**
     * Request param name for sort
     */
    String SORT = "sort";
    /**
     * Params for pager
     */
    Collection<String> ForPager = Arrays.asList(PAGE, LIMIT);
    /**
     * Params for bunch by last identifier
     */
    Collection<String> ForBunchByIdentifier = Arrays.asList(LAST, LIMIT);
    /**
     * Params for bunch by offset
     */
    Collection<String> ForBunchByOffset = Arrays.asList(OFFSET, LIMIT);
}
