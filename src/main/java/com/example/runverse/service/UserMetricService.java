package com.example.runverse.service;

import com.example.runverse.dto.UserMetricRequest;
import com.example.runverse.model.UserMetric;
import com.example.runverse.repository.UserMetricRepository;
import com.example.runverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class UserMetricService {

    @Autowired
    private UserMetricRepository userMetricRepository;
    @Autowired
    private UserRepository userRepository;

    public UserMetric saveMetric(UserMetricRequest request) {
        // Check if user exists in UserRepository, NOT UserMetricRepository
        if (!userRepository.existsById(request.getUserId())) {
            throw new RuntimeException("User with ID " + request.getUserId() + " not found. Please login.");
        }
        UserMetric metric = new UserMetric();
        metric.setUserId(request.getUserId());
        metric.setHydration(request.getHydration());
        metric.setFatigue(request.getFatigue());
        metric.setPosture(request.getPosture());
        metric.setRecordedAt(new Date());
        metric.setDeviceId(request.getDeviceId());

        return userMetricRepository.save(metric);
    }

    public List<UserMetric> getMetricsByUserId(Long userId) {
        return userMetricRepository.findByUserId(userId);
    }
    @Transactional
    public void deleteMetricsWithNullDeviceId() {
        userMetricRepository.deleteByDeviceIdIsNull();
    }





}
