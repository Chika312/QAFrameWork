package org.example.api.entities;

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
public class Course extends BaseEntity{
    @JsonInclude(JsonInclude.Include.NON_NULL)
   public String id ;
   public String name;
   public String description;
   public String code;
   @JsonProperty(value = "category_id")
   public String categoryId;
}
