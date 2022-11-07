package com.server.software.dev.kolesnyk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.server.software.dev.kolesnyk.entity.UserEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class UserDto implements Serializable {
    @NotBlank
    private String name;
    @NotNull
    @Min(value = 0, message = "cannot apply balance < 0")
    private Integer balance;
}