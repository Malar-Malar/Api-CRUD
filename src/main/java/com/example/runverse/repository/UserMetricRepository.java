package com.example.runverse.repository;

import com.example.runverse.model.UserMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserMetricRepository extends JpaRepository<UserMetric, Long> {
    List<UserMetric> findByUserId(Long userId);
    void deleteByDeviceIdIsNull();

}
