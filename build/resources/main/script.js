// script.js
let username = "";
let socket;
let chatRoomId;

let webSocket;

function openWebSocket() {
    if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
        console.log("WebSocket is already opened.");
        return;
    }

    // WebSocket 연결을 시작합니다.
    webSocket = new WebSocket("ws://localhost:8080/ws/message");

    // 서버로부터 메시지를 받았을 때의 이벤트 핸들러입니다.
    webSocket.onmessage = function (event) {
        displayMessage("Server", event.data);
    };

    // WebSocket 연결이 열렸을 때의 이벤트 핸들러입니다.
    webSocket.onopen = function (event) {
        displayMessage("System", "Connection opened");
    };

    // WebSocket 연결이 닫혔을 때의 이벤트 핸들러입니다.
    webSocket.onclose = function (event) {
        displayMessage("System", "Connection closed");
    };
}

function sendMessage() {
    const messageInput = document.getElementById("messageInput");
    const message = messageInput.value;
    messageInput.value = "";

    // 웹소켓 서버로 메시지를 보냅니다.
    webSocket.send(message);
}

// 페이지가 로드될 때 WebSocket 연결을 시작합니다.
window.onload = openWebSocket;
function registerName() {
    username = document.getElementById("username").value;
    // Initialize the WebSocket connection here
    socket = new WebSocket('ws://localhost:8080/ws/message');

    socket.onmessage = function(event) {
        const message = JSON.parse(event.data);
        displayMessage(message.username, message.text);
    };

    document.getElementById("usernameForm").style.display = "none";
    document.getElementById("chatContainer").style.display = "block";
}

function displayMessage(username, message) {
    const chatBox = document.getElementById("chatBox");
    const messageElement = document.createElement("div");
    messageElement.textContent = `${username}: ${message}`;
    chatBox.appendChild(messageElement);
}


function leaveChat() {
    // 서버에 채팅방 나가기를 요청하는 함수
    fetch('/api/chat/leave', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            username: username,
            chatRoomId: chatRoomId
        }),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Leave chat response:', data);
            chatRoomId = null; // 채팅방 ID를 null로 설정

            // UI 업데이트 및 초기화
            document.getElementById("chatContainer").style.display = "none";
            document.getElementById("usernameForm").style.display = "block";
            document.getElementById("chatBox").innerHTML = "";
            username = ""; // 사용자 이름 초기화
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}
