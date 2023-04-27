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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Simple pair for key and value
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 17.02.2021
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Simple pair")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPair<K, V> implements Serializable {

    @Schema(description = "Key")
    private K key;
    @Schema(description = "Value")
    private V value;

    public static <K, V> DTOPair<K, V> of(K key, V value) {
        return new DTOPair<>(key, value);
    }
}
