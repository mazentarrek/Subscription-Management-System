package com.mazen.subscriptionmanager.services;

import com.mazen.subscriptionmanager.enums.NotificationType;

public interface NotificationService {
    void sendNotification(Long userId, String message, NotificationType type);
    void markAsRead(Long notificationId);
}
