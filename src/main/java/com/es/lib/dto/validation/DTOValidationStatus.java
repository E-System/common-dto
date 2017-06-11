/*
 * Copyright (c) E-System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2015
 */

package com.es.lib.dto.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Collection;

/**
 * Статус валидации формы
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
