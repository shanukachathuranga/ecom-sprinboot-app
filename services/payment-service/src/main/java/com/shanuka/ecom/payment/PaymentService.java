package com.shanuka.ecom.payment;

import com.shanuka.ecom.notification.NotificationProducer;
import com.shanuka.ecom.notification.PaymentNotificationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(@Valid PaymentRequestDto requestDto) {
        var payment = repository.save(mapper.toPayment(requestDto));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        requestDto.orderReference(),
                        requestDto.amount(),
                        requestDto.paymentMethod(),
                        requestDto.customer().firstname(),
                        requestDto.customer().lastname(),
                        requestDto.customer().email()
                )
        );
        return payment.getId();
    }
}
