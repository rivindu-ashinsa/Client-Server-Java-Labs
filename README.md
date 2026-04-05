# Lab Based Practical Mock

Java implementations for client-server practical work using both socket programming and the built-in HTTP server API.

## Overview

This project contains two independent lab exercises:

- `SocketServerExam` implements a multi-threaded echo server using `ServerSocket` and `Socket`.
- `HttpServerExam` implements a simple HTTP server using `com.sun.net.httpserver.HttpServer`.

Each class can be run separately.

## Project Structure

- `src/main/java/com/mycompany/lab_based_practical_mock_socket/SocketServerExam.java`
- `src/main/java/com/mycompany/lab_based_practical_mock_httpserver/HttpServerExam.java`
- `pom.xml`

## Requirements

- Java 17
- Maven 3.8+ or later

## Build

From the project root:

```bash
mvn clean package
```

This compiles the sources into `target/classes`.

## Run the Socket Server

The socket server listens on port `7000` and echoes each line sent by a client.

```bash
java -cp target/classes com.mycompany.lab_based_practical_mock_socket.SocketServerExam
```

Example client test:

```bash
nc localhost 7000
```

Type a message and press Enter. The server responds with `Echo: <message>`.

## Run the HTTP Server

The HTTP server listens on port `8000`.

```bash
java -cp target/classes com.mycompany.lab_based_practical_mock_httpserver.HttpServerExam
```

Available endpoints:

- `GET /` returns a simple HTML welcome page.
- `POST /data` returns a mock JSON response with `Content-Type: application/json`.

Example requests:

```bash
curl http://localhost:8000/
curl -X POST http://localhost:8000/data -H "Content-Type: application/json" -d '{"name":"test"}'
```

## Notes

- The socket server handles each client connection on a separate thread.
- Both servers are intentionally simple and match the lab-style TODO structure in the source code.
- If you use Windows PowerShell, you can run the same `java -cp ...` commands from the project root.
