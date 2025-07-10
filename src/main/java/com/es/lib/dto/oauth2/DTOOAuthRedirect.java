package com.es.lib.dto.oauth2;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "DTOOAuthRedirect", description = "Information for OAuth2 redirect")
@ApiModel(description = "Information for OAuth2 redirect")
public class DTOOAuthRedirect implements Serializable {

    @ApiObjectField(description = "URL to redirect", order = 0)
    @ApiModelProperty(notes = "URL to redirect", position = 0)
    private String url;
    @ApiObjectField(description = "Unique UUID for redirect", order = 1)
    @ApiModelProperty(notes = "Unique UUID for redirect", position = 1)
    private String state;
}