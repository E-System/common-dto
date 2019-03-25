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

import com.es.lib.dto.validation.DTOValidationField;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.Collection;

/**
 * Request validation information with message and type
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 25.03.19
 */
@ApiObject(name = "DTOValidationResult", description = "Request validation result")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOValidationResult extends DTOResult {

    @ApiObjectField(description = "Request validation information", order = 4)
    private Collection<DTOValidationField> fields;

    public DTOValidationResult() { }

    public DTOValidationResult(String msg, Collection<DTOValidationField> fields) {
        super(msg);
        this.fields = fields;
    }

    public DTOValidationResult(String msg, String errorCode, Collection<DTOValidationField> fields) {
        super(msg, errorCode);
        this.fields = fields;
    }

    public DTOValidationResult(DTOLocalizeMessage localizeMessage, Collection<DTOValidationField> fields) {
        super(localizeMessage);
        this.fields = fields;
    }

    public DTOValidationResult(DTOLocalizeMessage localizeMessage, String msg, Collection<DTOValidationField> fields) {
        super(localizeMessage, msg);
        this.fields = fields;
    }

    public DTOValidationResult(DTOLocalizeMessage localizeMessage, String msg, String errorCode, Collection<DTOValidationField> fields) {
        super(localizeMessage, msg, errorCode);
        this.fields = fields;

    }

    public Collection<DTOValidationField> getFields() {
        return fields;
    }

    public void setFields(Collection<DTOValidationField> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "DTOValidationResult{" +
               "fields=" + fields +
               "} " + super.toString();
    }
}
