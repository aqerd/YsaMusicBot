package rs.aqerd;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static rs.aqerd.shared.Environment.getTelegramToken;
import static rs.aqerd.shared.Environment.getTelegramUsername;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String text = message.getText();
            String userId = String.valueOf(message.getChatId());

            System.out.println(text);

            executeMessage(text, userId);
        }
    }

    public void executeMessage(String text, String userId) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(userId)
                .text(text)
                .build();

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return getTelegramUsername();
    }

    @Override
    public String getBotToken() {
        return getTelegramToken();
    }
}
