package com.aamir.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class OtpCache {

    private static final LoadingCache<String, Integer> otpCache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
                @Override
                public Integer load(String key) throws Exception {
                    return 0;
                }
            });

    public static void saveOtp(String emailOrPhone, Integer otp) {
        otpCache.put(emailOrPhone, otp);
    }

    public static Integer getOtp(String emailOrPhone) {
        try {
            return otpCache.get(emailOrPhone);
        } catch (Exception e) {
            return null;
        }
    }

    public static void deleteOtpFromCache(String emailOrPhone){
        otpCache.invalidate(emailOrPhone);
    }
}
