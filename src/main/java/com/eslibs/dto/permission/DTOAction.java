package com.eslibs.dto.permission;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Access action")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOAction implements Serializable {

    @Schema(description = "Code")
    private String code;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Active for current configuration")
    private boolean enabled;
}
