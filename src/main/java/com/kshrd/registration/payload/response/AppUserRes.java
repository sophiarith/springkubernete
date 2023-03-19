package com.kshrd.registration.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kshrd.registration.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserRes {
    private int id;
    private String fullname;
    private String email;
    private String nationalCard;
    private Province pob;
    private String phone;
    private String emergencyPhone;
    private Education education;
    private String gender;
    private LocalDateTime dob;
    private Province address;
    private Relative relative;
    private University university;
    private String referenceUrl;
    private LocalDateTime createDate;
    private Boolean status;
    private String photoUrl;
    private Generation generation;
    @JsonIgnore
    private String token;
    private String jwtToken;
    private Boolean isDonated;
    private List<Role> roles;

}
