package com.mobile.demo.controller;


import com.mobile.demo.dao.AnswerEntityRepository;
import com.mobile.demo.model.AnswerEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class AnswerController {

    private AnswerEntityRepository answerEntityRepository;

    public AnswerController (AnswerEntityRepository answerEntityRepository){
        this.answerEntityRepository = answerEntityRepository;
    }

    @GetMapping("/answer/{id}")
    @ResponseBody
    public AnswerEntity findAnswerById(@PathVariable int id){
        return answerEntityRepository.findAnswerById(id);
    }

    @GetMapping("/answer/{questionId}")
    @ResponseBody
    public ArrayList<AnswerEntity> findAllAnswersFromQuestion(@PathVariable int questionId){
        return answerEntityRepository.findAllAnswersByQuestionId(questionId);
    }

    @PostMapping("/answer")
    @ResponseBody
    public String addAnswer(@RequestBody AnswerEntity answerEntity){
        answerEntityRepository.save(answerEntity);
        return "success";
    }

    @PutMapping("/answer")
    @ResponseBody
    public String updateAnswer(@RequestBody AnswerEntity answerEntity){
        AnswerEntity answerEntity1 = answerEntityRepository.findAnswerById(answerEntity.getAnswerId());
        answerEntity1.setAnswerDescription(answerEntity.getAnswerDescription());
        answerEntityRepository.save(answerEntity1);
        return "success";
    }

    @DeleteMapping("/answer/delete/{answerId}")
    @ResponseBody
    public String deleteAnswer(@PathVariable int answerId){
        answerEntityRepository.delete(answerEntityRepository.findAnswerById(answerId));
        return "success";
    }


}
