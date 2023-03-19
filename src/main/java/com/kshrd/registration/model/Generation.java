package com.kshrd.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Generation {
    private Integer id;
    private String name;
    private Boolean status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer delayDay;
    private String description;
    private String[] examUrl;
    private String timelineUrl;
}
