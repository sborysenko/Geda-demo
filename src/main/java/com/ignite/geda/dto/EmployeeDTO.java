package com.ignite.geda.dto;

/**
 * Created by Sergey on 07.10.2015.
 */
public interface EmployeeDTO {
    public Long getId();

    public void setId(Long id);

    String getFullName();

    void setFullName(String fullName);

    String getPosition();

    void setPosition(String position);

    public String getPhoneNumber();

    public void setPhoneNumber(String phoneNumber);

    String getDeskNumber();

    void setDeskNumber(String deskNumber);
}
