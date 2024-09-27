package com.nakarmi.mcq.controller;

import com.nakarmi.mcq.entity.MCQDocument;
import com.nakarmi.mcq.repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class QuizController {

    @Autowired
    private MCQRepository quizRepository;

    @GetMapping("quizzes")
    public Map<String, List<MCQDocument>> getAllQuizzes() {
        Map<String, List<MCQDocument>> mcqDocumentsMap = new HashMap<>();
        mcqDocumentsMap.put("questions", quizRepository.findAll());
        return mcqDocumentsMap;
    }

    @PostMapping
    public MCQDocument createQuiz(@RequestBody MCQDocument quiz) {
        return quizRepository.save(quiz);
    }

    @PostMapping("/save-mcqs")
    public List<MCQDocument> createQuizFromText(@RequestBody Map<String, List<MCQDocument>> input) {
//        List<MCQDocument> mcqDocuments = MCQParser.parseMCQToJson(input);
//        Map<String, Object> mcqDocumentsMap = MCQParser.parseTextToJson(input);
        List<MCQDocument> mcqDocuments = input.get("questions");
        return quizRepository.saveAll(mcqDocuments);
    }

    @PostMapping("/parse-text")
    public Map<String, List<MCQDocument>> ccheckQuizMCQFromText(@RequestBody Map<String, String> request) {
        String inputText = request.get("text");
        List<MCQDocument> mcqDocuments = MCQParser.parseMCQToJson(inputText);
        Map<String, List<MCQDocument>> mcqDocumentsMap = new HashMap<>();
        mcqDocumentsMap.put("questions", mcqDocuments);
        return mcqDocumentsMap;
    }

    @PutMapping("/update-mcq/{questionId}")
    public MCQDocument updateMCQ(@PathVariable String questionId, @RequestBody MCQDocument mcqDocument) {
        mcqDocument.setId(questionId);
        MCQDocument updatedMCQ = quizRepository.save(mcqDocument);
        return updatedMCQ;
    }

    @GetMapping("/{id}")
    public MCQDocument getQuizById(@PathVariable String id) {
        return quizRepository.findById(id).orElse(null);
    }
}

