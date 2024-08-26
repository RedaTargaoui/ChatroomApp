/**
 * Represents chat message model class
 */
package com.redat.ChatroomApp.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    // Attributes:
    private String sender;
    private String content;
    private MessageType type;
}
