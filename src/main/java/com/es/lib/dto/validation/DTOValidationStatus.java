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

package com.es.lib.dto.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Collection;

/**
 * Form validation information with message and type
 *
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 10.04.15
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOValidationStatus implements Serializable {

    private Type type;
    private Collection<DTOValidationField> fields;

    public DTOValidationStatus() {
    }

    public DTOValidationStatus(Type type, Collection<DTOValidationField> fields) {
        this.type = type;
        this.fields = fields;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<DTOValidationField> getFields() {
        return fields;
    }

    public void setFields(Collection<DTOValidationField> fields) {
        this.fields = fields;
    }

    public enum Type {

        Info,
        Warn,
        Error,
        Fatal
    }

    @Override
    public String toString() {
        return "DTOValidationStatus [" +
               "type=" + type +
               ", fields=" + fields +
               ']';
    }
}
