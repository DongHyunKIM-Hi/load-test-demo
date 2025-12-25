package org.example.loadtestdemo.domain.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminOrderSummaryDto {
    private Long orderId;
    private Long userId;
    private String userGrade;
    private Integer totalOrderAmount;
}