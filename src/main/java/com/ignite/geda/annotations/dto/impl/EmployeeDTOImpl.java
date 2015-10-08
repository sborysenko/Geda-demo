package com.ignite.geda.annotations.dto.impl;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

/**
 * Created by Sergey on 06.10.2015.
 */
@Dto
public class EmployeeDTOImpl implements com.ignite.geda.dto.EmployeeDTO {
    @DtoField(converter = "id_converter")
    Long id;
    @DtoField(value = "firstName")
    private String fullName;
    @DtoField
    private String position;
    @DtoField(value = "phone")
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
