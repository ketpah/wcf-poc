package com.wcf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcf.model.FeatureRequestEntity;
import com.wcf.model.AssigneeEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;

public interface FeatureRequestRepository extends JpaRepository<FeatureRequestEntity,Integer> {

    // save exists

    @Query("Select fre from FeatureRequestEntity fre where fre.featureRequestId = :id")
    FeatureRequestEntity findById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE FeatureRequestEntity fre set fre.status = :status where fre.featureRequestId  = :id")
    void changeStatus(@Param("status")String status, @Param("id")Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE FeatureRequestEntity fre set fre.priority = :priority where fre.featureRequestId  = :id")
    void changePriority(@Param("priority")String priority, @Param("id")Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE FeatureRequestEntity fre set fre.assignee.assigneeId = :assigneeId where fre.featureRequestId  = :id")
    void setAssignee(@Param("assigneeId")Long assigneeId, @Param("id")Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE FeatureRequestEntity fre set fre.targetDate = :targetDate where fre.featureRequestId  = :id")
    void setDate(@Param("targetDate")Date targetDate, @Param("id")Integer id);

}
