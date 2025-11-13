# NFC Card Review System

A Spring Boot–based backend system that allows customers to tap an NFC card and instantly open the Google Review page of a business. The system also provides admin and user dashboards to manage businesses, link NFC cards, and track tap analytics.

---

## Features

### NFC Tap → Google Review Redirect  
- Each NFC card is mapped to a specific business.  
- When a customer taps the card, it automatically opens the Google Review page.  
- Backend logs every tap for analytics.

### Role-Based Authentication (Spring Security)
Two roles were implemented:
- **Admin**
  - Add and manage businesses  
  - Register/link NFC cards  
  - View all tap logs and analytics  
- **User**
  - Access only their own business dashboard  
  - View tap count and update their Google Review link  

### Database (PostgreSQL)
Stores:
- Businesses  
- Google review URLs  
- NFC card mappings  
- Tap logs (timestamp, card, device, etc.)  
- User accounts and roles  

---

## System Workflow

1. NFC card stores a unique card ID or encoded URL.
2. User taps NFC card on their phone.
3. Phone triggers backend endpoint.
4. Backend:
   - Logs the tap  
   - Looks up linked business  
   - Redirects user to that business’s Google Review page  

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Spring Boot, Spring Security |
| Database | PostgreSQL |
| Auth | JWT / Spring Security |
| NFC | Encoded URL or NFC Tag ID |

---


## ⚙️ Configuration (application.properties)

Before running, update:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DB
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Steps to run
```bash
git clone https://github.com/vittalkatwe/nfc-card-review-backend.git
cd nfc-card-review-backend
mvn clean install
mvn spring-boot:run
```

