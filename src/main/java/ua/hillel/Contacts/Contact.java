package ua.hillel.Contacts;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Contact implements Serializable {
    private String name;
    private String phone;
    private Type type;
}
