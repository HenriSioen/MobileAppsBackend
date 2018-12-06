package com.mobile.demo.controller;


import com.mobile.demo.dao.QuestionEntityRepository;
import com.mobile.demo.model.QuestionEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class QuestionController {

    private QuestionEntityRepository questionEntityRepository;

    public QuestionController(QuestionEntityRepository questionEntityRepository){
        this.questionEntityRepository = questionEntityRepository;
    }

    @GetMapping("/question")
    @ResponseBody
    public ArrayList<QuestionEntity> findAllQuestions(){
        return (ArrayList<QuestionEntity>) questionEntityRepository.findAll();
    }

    @GetMapping("question/{id}")
    @ResponseBody
    public QuestionEntity findQuestionById (@PathVariable int id){
        return questionEntityRepository.findQuestionById(id);
    }

    @PostMapping("/question")
    @ResponseBody
    public String addQuestion(@RequestBody QuestionEntity questionEntity){
        questionEntityRepository.save(questionEntity);
        return "success";
    }

    @PutMapping("/question")
    @ResponseBody
    public String updateQuestion(@RequestBody QuestionEntity questionEntity){
        QuestionEntity questionEntity1 = questionEntityRepository.findQuestionById(questionEntity.getQuestionId());
        questionEntity1.setQuestionTitle(questionEntity.getQuestionTitle());
        questionEntity1.setQuestionDescription(questionEntity.getQuestionDescription());
        questionEntityRepository.save(questionEntity1);
        return "success";
    }

    @DeleteMapping("/question/delete/{id}")
    @ResponseBody
    public String deleteQuestion(@PathVariable int id){
        questionEntityRepository.delete(questionEntityRepository.findQuestionById(id));
        return "success";
    }


}
