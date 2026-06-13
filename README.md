# 📬 Mail Service API

A lightweight, production-ready Spring Boot application for sending emails via SMTP — supports plain text messages and file attachments through a clean REST API.

---

## ✨ Features

- Send plain text emails via `SimpleMailMessage`
- Send emails with file attachments via `MimeMessage`
- Gmail SMTP integration with STARTTLS
- RESTful API with clean service-based architecture
- Minimal configuration, easy to extend

---

## 🛠️ Tech Stack

| Layer        | Technology         |
|--------------|--------------------|
| Language     | Java 21            |
| Framework    | Spring Boot 3      |
| Mail         | Spring Mail (JavaMail) |
| Build Tool   | Maven              |
| Utilities    | Lombok             |

---

## 📁 Project Structure

```
src/main/java/com/example/mailservice/
├── controller/       # REST endpoints
├── service/          # Business logic
├── model/            # Request/response DTOs
└── resources/
    └── application.properties
```

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- A Gmail account with an [App Password](https://support.google.com/accounts/answer/185833) enabled

### Clone & Run

```bash
git clone <repository-url>
cd MailService
mvn clean install
mvn spring-boot:run
```

---

## ⚙️ Configuration

Add your SMTP credentials to `src/main/resources/application.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> **Note:** Never commit real credentials. Use environment variables or a secrets manager in production.

---

## 📡 API Reference

### Send a Simple Email

```http
POST /api/mail/send
Content-Type: application/json
```

**Request Body:**

```json
{
  "to": "recipient@example.com",
  "subject": "Hello!",
  "message": "This is a test email from Mail Service API."
}
```

**Response:**

```
200 OK — Email sent successfully.
```

---

### Send an Email with Attachment

```http
POST /api/mail/send-attachment
Content-Type: multipart/form-data
```

**Form Parameters:**

| Parameter | Type   | Description              |
|-----------|--------|--------------------------|
| `to`      | String | Recipient email address  |
| `subject` | String | Email subject line       |
| `message` | String | Body of the email        |
| `file`    | File   | Attachment to be sent    |

**Response:**

```
200 OK — Email with attachment sent successfully.
```

---

## 🗺️ Roadmap

- [ ] HTML email templates (Thymeleaf / Freemarker)
- [ ] OTP / verification email support
- [ ] Async email sending with `@Async`
- [ ] Email queue using Kafka or RabbitMQ
- [ ] Email scheduling with Spring Scheduler
- [ ] Retry mechanism with exponential backoff
- [ ] CC / BCC support
- [ ] Email delivery status tracking

---

## 🤝 Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m 'Add your feature'`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

---

## 👤 Author

**Sai Deepak**  
GitHub: [@saidepak111-sudo](https://github.com/saidepak111-sudo)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
