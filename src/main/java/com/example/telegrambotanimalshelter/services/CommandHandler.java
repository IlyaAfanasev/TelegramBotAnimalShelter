package com.example.telegrambotanimalshelter.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandHandler {
    SendMessage process(Update update);
}
