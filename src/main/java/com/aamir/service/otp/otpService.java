package com.aamir.service.otp;

import com.aamir.entity.Student;

import java.security.NoSuchAlgorithmException;

public interface otpService {
    String sendOtpSMS(boolean resendFlag, Student student) throws NoSuchAlgorithmException;
}
