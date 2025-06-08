package com.app.todolist.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    String name;
    String email;
    String password;
    String phone;
    String address;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dob;
}
