package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "DTOGeoPoint", description = "Geo point")
@ApiModel(description = "Geo point")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOGeoPoint {


    @ApiObjectField(description = "Latitude", order = 0)
    @ApiModelProperty(notes = "Latitude", position = 0)
    private double lat;
    @ApiObjectField(description = "Longitude", order = 1)
    @ApiModelProperty(notes = "Longitude", position = 1)
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