package com.nakarmi.mcq.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("messages")
public class MessageDocument {
    @Id
    private String id;
    private String name;
    private String message;
    private String email;
    @CreatedDate
    private LocalDateTime createdDate;

}
