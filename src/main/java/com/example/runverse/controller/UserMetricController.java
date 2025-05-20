package com.example.runverse.controller;


import com.example.runverse.dto.UserMetricRequest;
import com.example.runverse.model.UserMetric;
import com.example.runverse.service.UserMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class UserMetricController {
    @Autowired
    private UserMetricService metricService;

    @PostMapping
    public ResponseEntity<UserMetric> saveMetric(@RequestBody UserMetricRequest request) {
        return ResponseEntity.ok(metricService.saveMetric(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserMetric>> getMetrics(@PathVariable Long userId) {
        return ResponseEntity.ok(metricService.getMetricsByUserId(userId));
    }

    @DeleteMapping("/delete-null-device")
    public ResponseEntity<String> deleteNullDeviceMetrics() {
        metricService.deleteMetricsWithNullDeviceId();
        return ResponseEntity.ok("Deleted all metrics with null deviceId");
    }






}
