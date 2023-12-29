package com.aamir.service.otp.impl;

import com.aamir.entity.Student;
import com.aamir.response.MessageDetails;
import com.aamir.service.otp.otpService;
import com.aamir.util.OtpCache;
import com.aamir.util.StudentUtil;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class otpServiceImpl implements otpService {

    @Override
    public String sendOtpSMS(boolean resendFlag, Student student) throws NoSuchAlgorithmException {

        if (resendFlag){
            OtpCache.deleteOtpFromCache(student.getEmailOrPhoneNo());
        }
        Integer otp = generateOtp(student.getEmailOrPhoneNo());
        MessageDetails message = new MessageDetails();
        message.setMobileNo(student.getEmailOrPhoneNo());
        message.setMessage(otp + " is OTP for Registration. Valid Till " + StudentUtil.getTenMinutesFutureTimeOfCurrentTime());
        return null;
    }

    private Integer generateOtp(String emailOrPhoneNo) throws NoSuchAlgorithmException {
        int otp = getSecureOTP();
        OtpCache.saveOtp(emailOrPhoneNo, otp);
        return otp;
    }

    public static int getSecureOTP() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        return secureRandom.nextInt(900000) + 100000;
    }
}
