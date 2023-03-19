package com.kshrd.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    private Integer id;
    private String title;
    private String description;
    private String[] postUrl;
    private LocalDateTime createDate;
    private Boolean status;
    private Generation generation;
    private AppUser user;
}
