package com.nakarmi.mcq.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Document("messages")
public class MessageDocument {
    @Id
    private String id;
    private String name;
    private String message;
    private String email;
    @CreatedDate
    private LocalDateTime createdDate = ZonedDateTime.now(ZoneId.of("Asia/Kathmandu")).toLocalDateTime();
}
