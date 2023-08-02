package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Linked entity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOLinkedEntity implements Serializable {

    @Schema(description = "ID")
    private Long id;
    @Schema(description = "Entity type")
    private String type;
    @Schema(description = "Title")
    private String title;
}
