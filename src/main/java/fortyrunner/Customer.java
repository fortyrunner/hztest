package fortyrunner;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {

    private String firstName;
    private String surName;

    public Customer(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

}

