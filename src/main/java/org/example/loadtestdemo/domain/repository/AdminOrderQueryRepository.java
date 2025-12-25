package org.example.loadtestdemo.domain.repository;

import static org.example.loadtestdemo.common.entity.QOrder.order;
import static org.example.loadtestdemo.common.entity.QOrderItem.orderItem;
import static org.example.loadtestdemo.common.entity.QUser.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.loadtestdemo.domain.dto.AdminOrderSummaryDto;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminOrderQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<AdminOrderSummaryDto> findSummary(
        LocalDateTime from,
        LocalDateTime to
    ) {

        return queryFactory
            .select(Projections.constructor(
                AdminOrderSummaryDto.class,
                order.id,
                user.id,
                user.grade,
                orderItem.price.multiply(orderItem.quantity).sum()
            ))
            .from(order)
            .join(user).on(order.userId.eq(user.id))
            .join(orderItem).on(orderItem.orderId.eq(order.id))
            .where(
                order.orderedAt.between(from, to),
                order.status.eq("ORDERED")
            )
            .groupBy(
                order.id,
                user.id,
                user.grade
            )
            .orderBy(order.orderedAt.desc())
            .limit(50)
            .fetch();
    }
}