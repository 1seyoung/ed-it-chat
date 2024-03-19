package com.edit.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.WebSocketHandler

@Configuration //애플리케이션의 설정을 담당하는 클래스
@EnableWebSocket //스프링에게 웹소켓 기능을 활성화하도록 지시
class WebSocketConfig(
    val webSocketHandler: WebSocketHandler
): WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(webSocketHandler, "/ws/message").setAllowedOrigins("*")
    }
}