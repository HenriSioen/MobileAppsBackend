package com.mobile.demo.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mobile.demo.dao.AnswerEntityRepository;
import com.mobile.demo.dao.QuestionEntityRepository;
import com.mobile.demo.dao.UserEntityRepository;
import com.mobile.demo.model.AnswerEntity;
import com.mobile.demo.model.QuestionEntity;
import com.mobile.demo.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class AnswerController {

    private AnswerEntityRepository answerEntityRepository;
    private QuestionEntityRepository questionEntityRepository;
    private UserEntityRepository userEntityRepository;

    public AnswerController (AnswerEntityRepository answerEntityRepository){
        this.answerEntityRepository = answerEntityRepository;
    }

    @GetMapping("/answer/{id}")
    @ResponseBody
    public AnswerEntity findAnswerById(@PathVariable int id){
        return answerEntityRepository.findAnswerById(id);
    }

    @GetMapping("/answer/question/{questionId}")
    @ResponseBody
    public ArrayList<AnswerEntity> findAllAnswersFromQuestion(@PathVariable int questionId){
        return answerEntityRepository.findAllAnswersByQuestionId(questionId);
    }

    @PostMapping("/answer")
    @ResponseBody
    public AnswerEntity addAnswer(@RequestBody AnswerEntity answerEntity){
        answerEntityRepository.save(answerEntity);
        return answerEntity;
    }

    @PutMapping("/answer")
    @ResponseBody
    public AnswerEntity updateAnswer(@RequestBody AnswerEntity answerEntity){
        AnswerEntity answerEntity1 = answerEntityRepository.findAnswerById(answerEntity.getAnswerId());
        answerEntity1.setAnswerDescription(answerEntity.getAnswerDescription());
        answerEntityRepository.save(answerEntity1);
        return answerEntity;
    }

    @DeleteMapping("/answer/delete/{answerId}")
    @ResponseBody
    public String deleteAnswer(@PathVariable int answerId){
        answerEntityRepository.delete(answerEntityRepository.findAnswerById(answerId));
        return "success";
    }


}
