package com.wcf.service;

import com.wcf.model.FeatureRequestEntity;
import com.wcf.model.FeatureRequestEntity.Status;
import com.wcf.model.FeatureRequestEntity.Area;
import com.wcf.model.FeatureRequestEntity.Priority;
import com.wcf.repository.FeatureRequestRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;

@Service
public class FeatureRequestAppService {

    @Resource
    private FeatureRequestRepository featureRequestRepository;


    public void createFeatureRequest(FeatureRequestEntity fre){
        featureRequestRepository.save(fre);
    }

    public Status getFeatureRequestStatus(Integer id){
        FeatureRequestEntity fre = featureRequestRepository.findById(id);
        Status status = fre.getStatus();
        return status;
    }

    public Priority getFeatureRequestPriority(Integer id){
        FeatureRequestEntity fre = featureRequestRepository.findById(id);
        Priority priority = fre.getPriority();
        return priority;
    }

    public Area getFeatureRequestArea(Integer id){
        FeatureRequestEntity fre = featureRequestRepository.findById(id);
        Area area = fre.getProductArea();
        return area;
    }

    // id of assignee
    public void assignFeatureRequest(Long assigneeId, Integer id){
        featureRequestRepository.setAssignee(assigneeId, id);
    }

    public void setFeatureRequestDate(Date targetDate,Integer id){
        featureRequestRepository.setDate(targetDate, id);
    }

    public void changeFeatureRequestPriority(String priority,Integer id){
        featureRequestRepository.changePriority( priority, id);
    }

    public void changeFeatureRequestStatus(String status,Integer id){
        featureRequestRepository.changePriority( status, id);
    }

}
