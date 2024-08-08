package com.base.certification.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private String id;
    private String createLogin;
}