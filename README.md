# Chat Application

This project is a chat application built using JavaFX and a RESTful API. JavaFX is used to create the user interface, while the RESTful API is used to communicate with the server.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- Real-time chat between users
- View message history
- Send messages with a username
- Modern user interface with JavaFX
- Server communication using RESTful API

## Requirements

- Java 11 or higher
- Maven
- A RESTful API server (example provided using Spring Boot)

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Hasankb44/chat-app.git
    cd chat-app
    ```

2. **Install Maven dependencies:**

    ```bash
    mvn clean install
    ```

3. **Start the API Server:**

    Run the Spring Boot application by executing `src/main/java/com/hkb/musicservice/chatgui142/ApiServer.java`.

4. **Start the JavaFX Application:**

    Run the JavaFX application by executing `src/main/java/com/hkb/musicservice/chatgui142/ChatApplication.java`.

## Usage

- **Send a Message:** 
  - Enter your username and message, then click the "Send" button.
- **View Messages:**
  - Incoming messages will automatically be displayed in the message list.

## API Documentation

### Send Message

- **URL:** `/api/message/send`
- **Method:** `POST`
- **Parameters:**
  - `author`: The username of the person sending the message (String)
  - `message`: The content of the message (String)
- **Example Response:**
  ```json
  {
      "status": "success",
      "message": "Message sent successfully."
  }
