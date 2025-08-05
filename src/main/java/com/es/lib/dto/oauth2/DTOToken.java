/*
 * Copyright (c) E-System LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2018
 */

package com.es.lib.dto.oauth2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

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
@ApiObject(name = "DTOToken", description = "Token response")
@ApiModel(description = "Token response")
public class DTOToken implements Serializable {

    @ApiObjectField(description = "Access token", order = 0)
    @ApiModelProperty(notes = "Access token", position = 0)
    @JsonProperty(value = "access_token")
    private String accessToken;
    @ApiObjectField(description = "Token type", order = 1)
    @ApiModelProperty(notes = "Token type", position = 1)
    @JsonProperty(value = "token_type")
    private String tokenType;
    @ApiObjectField(description = "Refresh token", order = 2)
    @ApiModelProperty(notes = "Refresh token", position = 2)
    @JsonProperty(value = "refresh_token")
    private String refreshToken;
    @ApiObjectField(description = "Expires in", order = 3)
    @ApiModelProperty(notes = "Expires in", position = 3)
    @JsonProperty(value = "expires_in")
    private long expiresIn;
    @ApiObjectField(description = "Scope", order = 4)
    @ApiModelProperty(notes = "Scope", position = 4)
    @JsonProperty(value = "scope")
    private String scope;
    @ApiObjectField(description = "JTI", order = 5)
    @ApiModelProperty(notes = "JTI", position = 5)
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
