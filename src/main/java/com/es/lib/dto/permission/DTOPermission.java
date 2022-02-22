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
@Schema(description = "Permission configuration")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPermission implements Serializable {

    @Schema(description = "All available actions")
    private Collection<DTOAction> actions;
    @Schema(description = "Access item groups")
    private Collection<DTOGroup> items;
}
