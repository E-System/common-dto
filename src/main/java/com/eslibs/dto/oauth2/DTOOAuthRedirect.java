package com.eslibs.dto.oauth2;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Information for OAuth2 redirect")
public class DTOOAuthRedirect implements Serializable {

    @Schema(description = "URL to redirect")
    private String url;
    @Schema(description = "Unique UUID for redirect")
    private String state;
}