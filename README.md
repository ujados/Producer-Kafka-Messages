# Producer-Kafka-Messages

Kafka message producer using **Spring Boot**, running **Apache Kafka in KRaft mode** (no Zookeeper) via **Docker Compose**. Includes **Kafka UI** for visualizing topics and messages.

---

## 🧩 Technologies Used

- Java 17
- Spring Boot 3
- Apache Kafka (KRaft mode)
- Docker & Docker Compose
- Kafka UI (provectuslabs/kafka-ui)

---

## 🚀 What does this project do?

This project sends messages to a Kafka topic using a Spring Boot producer. Kafka runs in **KRaft mode** (ZooKeeper-less), and **Kafka UI** is included to monitor topics and messages.

Messages are produced from a **JUnit test** (not via REST endpoint).

---

## 📦 How to Run

### Requirements

- [Docker](https://www.docker.com/)
- [Java 17+](https://adoptium.net/)
- (Optional) [IntelliJ IDEA](https://www.jetbrains.com/idea/) or your preferred IDE

### 1. Clone the repository

```
git clone https://github.com/ujados/Producer-Kafka-Messages.git
cd Producer-Kafka-Messages
```

### 2. Start Kafka and Kafka UI

```
docker-compose up -d
```

Kafka broker runs at: localhost:9092
Kafka UI is available at: http://localhost:8080

### 3. Run the Spring Boot test

You can run the test class to produce a message. From IntelliJ or using:
```
./mvnw test
```

### 4. Producing a Message from Test

The message is produced by running the JUnit test located in:

src/test/java/KafkaProducerDirectTest.java

This test sends a message to the topic configured in your Kafka producer.

### 5. View Messages in Kafka UI

Access http://localhost:8080 in your browser.

There you can:

    View existing topics

    Explore messages

    Create or delete topics

### 6. Useful Commands
View Kafka logs
```
docker logs -f kafka
```
Stop services
```
docker-compose down
```
Stop and remove volumes (in case of CLUSTER_ID or storage issues)
```
docker-compose down -v
```