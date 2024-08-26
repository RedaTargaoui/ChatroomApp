/**
 * Represents chat controller
 */
package com.redat.ChatroomApp.Controller;

import com.redat.ChatroomApp.Model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    /**
     * Send a message
     * @param chatMessage ChatMessage
     * @return ChatMessage
     */
    @MessageMapping("/chat.sendMessage/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    /**
     * Add user to chatroom
     * @param chatMessage ChatMessage
     * @param simpMessageHeaderAccessor SimpMessageHeaderAccessor
     * @return ChatMessage
     */
    @MessageMapping("/chat.addUser/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor simpMessageHeaderAccessor) {
        // Add username to websocket session:
        simpMessageHeaderAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
