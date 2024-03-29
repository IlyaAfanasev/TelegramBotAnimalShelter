package com.example.telegrambotanimalshelter.repositories;

import com.example.telegrambotanimalshelter.models.Subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    void deleteByChatId(Long chatId);

    Subscriber findByChatId(Long chatId);
}
