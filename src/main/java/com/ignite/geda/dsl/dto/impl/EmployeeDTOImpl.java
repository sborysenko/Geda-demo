package com.ignite.geda.dsl.dto.impl;

import com.ignite.geda.dto.EmployeeDTO;

/**
 * Created by Sergey on 06.10.2015.
 */
public class EmployeeDTOImpl implements EmployeeDTO {
    Long id;
    private String fullName;
    private String position;
    private String phoneNumber;
    private String deskNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }
}
