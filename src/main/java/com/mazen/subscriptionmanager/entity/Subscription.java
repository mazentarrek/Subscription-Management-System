package com.mazen.subscriptionmanager.entity;

import com.mazen.subscriptionmanager.enums.BillingCycle;
import com.mazen.subscriptionmanager.enums.Currency;
import com.mazen.subscriptionmanager.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", length = 500)
    private String description;

    @Column(nullable = false)
    private double cost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 3)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 4)
    private BillingCycle billingCycle;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate nextBillingDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 4)
    private SubscriptionStatus status;

    private boolean reminderEnabled = true;

    private String website;

    private String logoURL;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
