package by.it.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String phone;
}
