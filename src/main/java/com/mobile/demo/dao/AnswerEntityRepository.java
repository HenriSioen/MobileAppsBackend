package com.mobile.demo.dao;


import com.mobile.demo.model.AnswerEntity;
import com.mobile.demo.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("AnswerEntityRepository")
public interface AnswerEntityRepository extends CrudRepository<AnswerEntity, Integer> {

    @Query("select a from AnswerEntity  a where a.questionEntity.questionId = :questionId")
    ArrayList<AnswerEntity> findAllAnswersByQuestionId(@Param("questionId") int questionId);

    @Query("select a from AnswerEntity a where a.answerId = :answerId")
    AnswerEntity findAnswerById(@Param("answerId") int answerId);
}
