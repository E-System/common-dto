package com.es.lib.dto.compat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request process result (compat)")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOResultCompat implements Serializable {

    @Schema(description = "Http code")
    private int code;
    @Schema(description = "Error code")
    private String errorCode;
    @Schema(description = "Error message")
    private String msg;

    public DTOResultCompat(int code) {
        this.code = code;
    }
}
