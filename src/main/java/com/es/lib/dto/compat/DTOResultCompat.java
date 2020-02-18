package com.es.lib.dto.compat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Request process result (compat)")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOResultCompat implements Serializable {

    @ApiModelProperty(notes = "Http code", position = 0)
    private int code;
    @ApiModelProperty(notes = "Error code", position = 1)
    private String errorCode;
    @ApiModelProperty(notes = "Error message", position = 2)
    private String msg;

    public DTOResultCompat(int code) {
        this.code = code;
    }
}
