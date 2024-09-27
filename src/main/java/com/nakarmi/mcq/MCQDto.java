package com.nakarmi.mcq;

import lombok.Data;

import java.util.List;

@Data
public class MCQDto {

    private String question;
    private List<String> options;
    private boolean multipleAnswers;
}
