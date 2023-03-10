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

    public static DTOImageReference create(Enum<?> value, String name) {
        return create(value, name, null, null);
    }

    public static DTOImageReference create(Enum<?> value, String name, String imagePrefix) {
        return create(value, name, imagePrefix, null);
    }

    public static DTOImageReference create(Enum<?> value, String name, String pathPrefix, String ext) {
        if (ext == null || ext.isEmpty()) {
            ext = "png";
        }
        String path = ((pathPrefix != null && !pathPrefix.isEmpty()) ? (pathPrefix + "/") : "") + value.name() + "." + ext;
        return new DTOImageReference(
            value.name(),
            name,
            new DTOFileStore(
                path,
                value.name(),
                ext,
                null,
                0
            )
        );
    }
}
