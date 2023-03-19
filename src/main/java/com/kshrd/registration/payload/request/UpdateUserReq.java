package com.kshrd.registration.payload.request;

import com.kshrd.registration.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserReq {
    private Integer id;
    private String fullname;
    private String email;
    private String nationalCard;
    private Integer pobId;
    private String phone;
    private String emergencyPhone;
    private Integer educationId;
    private String gender;
    private LocalDateTime dob;
    private Integer addressId;
    private Integer relativeId;
    private Integer universityId;
    private String referenceUrl;
    private LocalDateTime createDate;
    private Boolean status;
    private String photoUrl;
    private Integer generationId;
}
