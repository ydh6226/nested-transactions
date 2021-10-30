package com.transaction.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InnerService {

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public String innerMethod(int age) {
        log.info("innerMethod 시작 : " + age);

        // db에 age insert

        if (age == 1) {
            log.info("innerMethod 예외발생 : " + age + "\n");
            throw new IllegalArgumentException("예외 발생");
        }

        log.info("innerMethod 종료 : " + age + "\n");

        return String.valueOf(age);
    }
}
