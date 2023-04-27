package com.eslibs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Patch request")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPatchRequest<T> {

    @Schema(description = "Fields to update")
    private Set<String> fields;
    @Schema(description = "Data object")
    private T data;

    public <R> Patcher<T, R> patcher(R entity) {
        return new Patcher<>(this, entity);
    }
}
