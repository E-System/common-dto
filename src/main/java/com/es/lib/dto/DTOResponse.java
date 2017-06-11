/*
 * Copyright (c) E-System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2015
 */

package com.es.lib.dto;

import org.omg.CORBA.Object;

/**
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
public class DTOResponse<T> extends DTOBaseResponse<T, Object> {

    public DTOResponse() {
        super();
    }

    public DTOResponse(DTOResult result, T data) {
        super(result, data);
    }
}
