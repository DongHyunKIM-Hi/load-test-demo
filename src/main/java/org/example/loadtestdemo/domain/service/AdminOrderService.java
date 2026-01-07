package org.example.loadtestdemo.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.loadtestdemo.domain.dto.AdminOrderSummaryDto;
import org.example.loadtestdemo.domain.repository.AdminOrderQueryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminOrderService {

    private final AdminOrderQueryRepository queryRepository;

    @Transactional(readOnly = true)
    public List<AdminOrderSummaryDto> getSummary() {
        log.info("Info 로그 기록");
        log.error("Error 로그 기록");
        log.warn("Warn 로그 기록");
        return queryRepository.findSummary();
    }
}