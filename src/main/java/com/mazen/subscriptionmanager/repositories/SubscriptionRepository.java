package com.mazen.subscriptionmanager.repositories;

import com.mazen.subscriptionmanager.entity.Subscription;
import com.mazen.subscriptionmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByName(String name);

    List<Subscription> findAllByUser(User user);
}
