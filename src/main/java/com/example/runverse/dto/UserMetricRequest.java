package com.example.runverse.dto;

import lombok.Data;

@Data

public class UserMetricRequest {

    private Long userId;
    private String deviceId;
    private double hydration;
    private double fatigue;
    private double posture;
}
