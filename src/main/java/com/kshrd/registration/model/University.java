package com.kshrd.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {
    private Integer id;
    private String name;
    private String abbreviation;
    private Boolean status;
}
