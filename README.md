# Chat Application

This project is a chat application built using JavaFX and a RESTful API. JavaFX is used to create the user interface, while the RESTful API is used to communicate with the server.

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

### Pom Libraries (JavaFX)

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>22-ea+11</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>22-ea+11</version>
        </dependency>
        <dependency>
            <groupId>org.controlsfx</groupId>
            <artifactId>controlsfx</artifactId>
            <version>11.1.2</version>
        </dependency>
        <dependency>
            <groupId>com.dlsc.formsfx</groupId>
            <artifactId>formsfx-core</artifactId>
            <version>11.6.0</version>
            <exclusions>
                <exclusion>
                    <groupId>org.openjfx</groupId>
                    <artifactId>*</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version>
        </dependency>
        <!-- HTTP client dependency -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.13</version>
        </dependency>
        <dependency>
            <groupId>org.kordamp.bootstrapfx</groupId>
            <artifactId>bootstrapfx-core</artifactId>
            <version>0.4.0</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

### Pom Libraries (Spring Boot Api)

    <dependencies>
    
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
  
	</dependencies>


### Data Base
- **PostgresSQL**
