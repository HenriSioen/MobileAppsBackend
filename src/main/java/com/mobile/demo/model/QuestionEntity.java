package com.mobile.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "question", schema = "mobile_apps")
public class QuestionEntity {

    private int questionId;
    private String questionTitle;
    private String questionDescription;
    private UserEntity userEntity;

    @Id
    @Column(name = "question_id")
    public int getQuestionId(){return questionId;}

    public void setQuestionId(int questionId) {this.questionId = questionId;}

    @Basic
    @Column(name = "question_title")
    public String getQuestionTitle(){return questionTitle;}

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    @Basic
    @Column(name = "question_description")
    public String getQuestionDescription(){return questionDescription;}

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity s) {
        userEntity = s;
    }
}
