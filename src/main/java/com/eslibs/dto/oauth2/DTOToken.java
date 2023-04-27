/*
 * Copyright (c) E-System LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2018
 */

package com.eslibs.dto.oauth2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 09.02.2018
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DTOToken implements Serializable {

    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "refresh_token")
    private String refreshToken;
    @JsonProperty(value = "expires_in")
    private long expiresIn;
    @JsonProperty(value = "scope")
    private String scope;
    @JsonProperty(value = "jti")
    private String jti;

    public DTOToken(String accessToken, String refreshToken, String tokenType) {
        this(accessToken, refreshToken, tokenType, null);
    }

    public DTOToken(String accessToken, String refreshToken, String tokenType, String scope) {
        this(accessToken, tokenType, refreshToken, 0, scope, null);
    }

    public interface Store {

        DTOToken getToken();

        DTOToken setToken(DTOToken token);

        default boolean isEmpty() {
            return getToken() == null;
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DefaultStore implements Store {

        private DTOToken token;

        @Override
        public DTOToken setToken(DTOToken token) {
            this.token = token;
            return token;
        }
    }
}
