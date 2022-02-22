package com.es.lib.dto.permission;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Access item group")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOGroup implements Serializable {

    @Schema(description = "Code")
    private String code;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Access items")
    private Collection<DTOTarget> items;
}
