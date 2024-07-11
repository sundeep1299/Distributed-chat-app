# Distributed Chat Application

This is a distributed chat application built with Java, Spring Boot, and Apache Kafka. It provides real-time messaging features and uses a microservices architecture to handle user management, message processing, and notifications.

## Project Structure
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── chatapp/
│   │               ├── ChatApplication.java
│   │               ├── controller/
│   │               │   └── ChatController.java
│   │               ├── model/
│   │               │   └── ChatMessage.java
│   │               └── service/
│   │                   ├── UserService.java
│   │                   ├── MessageService.java
│   │                   └── NotificationService.java
│   └── resources/
│       └── application.properties
## Features

- User registration and authentication
- Real-time messaging using Kafka
- Microservices architecture for scalability

## Technology Stack

- Java 11
- Spring Boot 2.5.x
- Apache Kafka
- Maven

## Setup and Installation

1. Ensure you have Java 11 and Maven installed on your system.
2. Clone this repository:

## API Endpoints

- POST `/api/chat/register` - Register a new user
- POST `/api/chat/login` - Authenticate a user
- POST `/api/chat/send` - Send a chat message

## Future Improvements

- Implement WebSocket for real-time notifications
- Add message persistence using a database
- Enhance security features
- Implement user presence functionality
- Add support for group chats

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License.
