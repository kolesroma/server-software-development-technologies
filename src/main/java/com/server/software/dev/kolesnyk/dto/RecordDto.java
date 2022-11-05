package com.server.software.dev.kolesnyk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.server.software.dev.kolesnyk.entity.RecordEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RecordDto implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer categoryId;
    private LocalDateTime createdAt;
    @NotNull
    @Min(value = 0, message = "cannot apply outgo < 0")
    private Integer outgo;
}