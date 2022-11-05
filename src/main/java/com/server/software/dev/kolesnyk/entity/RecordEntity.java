package com.server.software.dev.kolesnyk.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Record {
    private int id;
    private int userId;
    private int categoryId;
    private LocalDateTime createdAt;
    private int outgo;
}
