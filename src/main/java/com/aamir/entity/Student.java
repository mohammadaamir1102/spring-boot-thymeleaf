package com.aamir.entity;

import com.aamir.validator.ValidEmailOrPhone;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name cannot be empty!")
    private String studentName;
    @NotBlank(message = "Address cannot be empty!")
    private String studentAddress;
    @NotBlank(message = "Gender is mandatory")
    private String studentGender;
    @AssertTrue(message = "Agreement is mandatory")
    private boolean agreement;
    @ValidEmailOrPhone
    @NotBlank(message = "Email or Phone no is mandatory")
    private String emailOrPhoneNo;

    private String pinCode;
    private String country;

    @Transient
    private String captcha;

    @Transient
    private String hiddenCaptcha;

    @Transient
    private String realCaptcha;
}
