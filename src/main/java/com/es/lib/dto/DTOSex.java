package com.es.lib.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Gender")
public enum DTOSex {
    @Schema(description = "Male")
    MALE,
    @Schema(description = "Female")
    FEMALE
}

