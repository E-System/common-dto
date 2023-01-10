package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Geo point")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOGeoPoint {

    @Schema(description = "Latitude")
    private double lat;
    @Schema(description = "Longitude")
    private double lon;
}
