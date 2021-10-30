package com.transaction.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OuterService {

    private final InnerService innerService;

    @Transactional
    public void outerMethod() {
        log.info("outerMethod 시작\n");

        try {
            for (int i = 0; i < 3; i++) {
                innerService.innerMethod(i);
            }
        } catch (Exception e) {
            log.info("예외처리");
        }

        log.info("outerMethod 종료\n");
    }

}
