package com.springboot.resortmanagement.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String resortResortId;
}
