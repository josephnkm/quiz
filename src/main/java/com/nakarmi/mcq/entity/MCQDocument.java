package com.nakarmi.mcq.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("questions")
public class MCQDocument {
    @Id
    private String id;
    private String question;
    private List<Option> options = new ArrayList<>();
    private boolean multipleAnswers;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option {
        private String text;
        private String rationale;

        @JsonProperty("isCorrect")
        private boolean isCorrect;

        public Option(String text) {
            this.text = text;
        }
    }

}
