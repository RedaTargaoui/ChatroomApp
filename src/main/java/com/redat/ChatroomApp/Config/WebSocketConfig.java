/**
 * Represents web socket config for enabling and configuring WebSocket communication in a Spring Boot application
 * WebSocket is a protocol that provides communication channels over a single TCP connection
 */
package com.redat.ChatroomApp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configure the message broker that will be used to route messages between clients.
     * @param registry MessageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        // Set listener for messages with destinations prefixed with /topic
        // Messages sent to /topic/someDestination will be routed to all subscribers of that topic:
        registry.enableSimpleBroker("/topic");
    }

    /**
     * Registers a WebSocket endpoint that clients will use to connect to the WebSocket server.
     * @param registry StompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // This registers the /ws endpoint, which clients will use to establish a WebSocket connection:
        registry.addEndpoint("/ws").withSockJS();
    }
}
