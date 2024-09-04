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

    public static DTOGeoPoint from(String lat, String lon) {
        if (lat == null || lat.trim().isEmpty() || lon == null || lon.trim().isEmpty()) {
            return null;
        }
        lat = lat.trim();
        lon = lon.trim();
        return new DTOGeoPoint(
            Double.parseDouble(lat),
            Double.parseDouble(lon)
        );
    }
}
