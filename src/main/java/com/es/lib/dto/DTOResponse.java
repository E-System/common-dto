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

/**
 * Response with only data
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@ApiObject(name = "DTOResponse", description = "Simple response with data")
public class DTOResponse<T> extends DTOEnvironmentalResponse<T, Object> {

    @Deprecated
    public DTOResponse() {
        super();
    }

    @Deprecated
    public DTOResponse(DTOResult result, T data) {
        super(result, data);
    }

    public DTOResponse(T data) {
        super(data);
    }
}
