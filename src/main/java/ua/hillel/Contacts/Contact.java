package ua.hillel.Contacts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor @NoArgsConstructor
public class Contact implements Serializable {
    private String name;
    private String phone;
    private Type type;
}
