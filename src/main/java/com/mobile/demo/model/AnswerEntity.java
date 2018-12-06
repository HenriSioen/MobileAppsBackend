package com.mobile.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "answer", schema = "mobile_apps")
public class AnswerEntity {

    private int answerId;
    private String answerDescription;
    private QuestionEntity questionEntity;
    private UserEntity userEntity;

    @Id
    @Column(name = "answer_id")
    public int getAnswerId(){return answerId;}

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "answer_description")
    public String getAnswerDescription(){return answerDescription;}

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    @ManyToOne
    @JoinColumn(name = "answer_user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity s) {
        userEntity = s;
    }

    @ManyToOne
    @JoinColumn(name = "question_question_id")
    public QuestionEntity getQuestionEntity(){return questionEntity;}

    public void setQuestionEntity(QuestionEntity q){this.questionEntity = q;}
}
