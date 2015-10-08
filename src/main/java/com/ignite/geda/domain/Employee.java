package com.ignite.geda.domain;

/**
 * Created by Sergey on 06.10.2015.
 */
public interface Employee {
    public String getId();

    public void setId(String id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getPosition();

    void setPosition(String position);

    public String getPhone();

    public void setPhone(String phone);
}
