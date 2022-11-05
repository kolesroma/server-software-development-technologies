package com.server.software.dev.kolesnyk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
    private UserDto user;
    private CategoryDto category;
    private LocalDateTime createdAt;
    private Integer outgo;
}