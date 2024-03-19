package com.edit.chat.handler

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class SocketHandler(
        private val sessionList: ArrayList<WebSocketSession> = ArrayList()
): TextWebSocketHandler() {

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        //클라이언트로부터 메시지가 도착하면 호출

        sessionList.forEach { webSocketSession ->
            if (webSocketSession.isOpen) {
                webSocketSession.sendMessage(TextMessage(message.payload))
            }
        }


    }
    override fun afterConnectionEstablished(session: WebSocketSession) {
        //클라이언트가 서버로 연결되면 호출
        sessionList.add(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        //클라이언트와 서버의 연결이 끊기면 호출되는 메소드
        sessionList.remove(session)
    }


}