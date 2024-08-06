package com.ohgiraffers.pikka_backserver.questions.controller;

import com.ohgiraffers.pikka_backserver.questions.model.QuestionsDTO;
import com.ohgiraffers.pikka_backserver.questions.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insert/qna-list")
public class QuestionsController {
    private QuestionsService questionsService;

    @Autowired
    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionsDTO>> getAllQna(){
        List<QuestionsDTO> qnaList = questionsService.getAllQuestions();
        return ResponseEntity.ok(qnaList);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<QuestionsDTO> getQnaById(@PathVariable("contactId") Long contactId){
        QuestionsDTO qna = questionsService.getQuestionById(contactId);
        return ResponseEntity.ok(qna);
    }

    @PutMapping("{contactId}/answer")
    public ResponseEntity<QuestionsDTO> submitAnswer(@PathVariable("contactId") Long contactId, @RequestBody QuestionsDTO questionsDTO){
        QuestionsDTO updatedQna = questionsService.submitAnswer(contactId, questionsDTO);
        return ResponseEntity.ok(updatedQna);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteQna(@PathVariable("contactId") Long contactId){
        questionsService.deleteQna(contactId);
        return ResponseEntity.noContent().build();
    }
}
