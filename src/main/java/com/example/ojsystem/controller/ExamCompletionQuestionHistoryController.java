package com.example.ojsystem.controller;

import com.example.ojsystem.entity.ExamCompletionQuestionHistory;
import com.example.ojsystem.service.ExamCompletionQuestionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/examCompletionQuestionHistory")
public class ExamCompletionQuestionHistoryController {
    @Autowired
    ExamCompletionQuestionHistoryService examCompletionQuestionHistoryService;
}
