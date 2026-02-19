package com.mazen.subscriptionmanager.repositories;

import com.mazen.subscriptionmanager.entity.PaymentMethod;
import com.mazen.subscriptionmanager.enums.PaymentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    boolean existsBy(@NotBlank @Size(min = 4, max = 4) String s);

    boolean existsByType(@NotNull PaymentType type);

    boolean existsByLastFourDigitsAndTypeAndUserId(@NotBlank @Size(min = 4, max = 4) String s, @NotNull PaymentType type, Long userId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE PaymentMethod p SET p.isDefault = false WHERE p.user.id = :userId")
    void resetDefaultByUserId(@Param("userId") Long userId);}
