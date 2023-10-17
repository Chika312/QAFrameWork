package com.digitalnomads.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity  {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "id")
    public String id;
    @JsonProperty(value = "first_name")
    public String firstName;
    @JsonProperty(value = "last_name")
    public String lastName;
    public String email;
    String login;
    String password;
}
