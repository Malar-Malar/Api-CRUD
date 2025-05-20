package com.example.runverse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user_metrics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // or use @ManyToOne if needed
    private double hydration;
    private double fatigue;
    private double posture;
    private Date recordedAt;
    private String deviceId;

}
