package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Reference with image")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOImageReference {
    @Schema(description = "ID")
    private String id;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Image")
    private DTOFileStore image;
}
