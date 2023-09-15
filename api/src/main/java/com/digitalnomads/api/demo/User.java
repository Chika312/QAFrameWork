package org.example.api.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
