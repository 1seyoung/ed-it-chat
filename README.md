# ed-it-chat server

This is the server for the ed-it-chat project. It is a simple chat server that allows users to create and join chat rooms and send messages to each other.


## http api

### login
- `POST /login`
- request body:
  - `userId` - the user id
  - `username` - the user name
  - `chatroom` - the chat room to join
```bash
  {
  "uri": "/auth/login",
  "body": {
  "userId": "user1",
  "username": "user1",
  "chatroomId_lst": ["UUID1", "UUID2"]
  }
  }
```

### create chat room
- `POST /chatroom/create`
- request body:
  - `chatroom` - the chat room to create
```bash
  {
  "uri": "/chatroom/create",
  "body": {
  "chatroom": "room1"
  "chatroomId": "UUID1"
  }
  }
  
 ###
```


## build
- build the server with `./gradle build`
- run the server with `java -jar build/libs/ed-it-chat-0.0.1-SNAPSHOT.jar`

