package com.mobile.demo.dao;


import com.mobile.demo.model.QuestionEntity;
import com.mobile.demo.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("QuestionEntityRepository")
public interface QuestionEntityRepository extends CrudRepository<QuestionEntity, Integer> {

    @Query("select q from QuestionEntity q where q.id = :questionId")
    QuestionEntity findQuestionById(@Param("questionId") int id);


}
