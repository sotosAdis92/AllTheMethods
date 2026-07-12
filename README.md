# All The Methods 

## Learning Numerical Analysis, Gamified

**All The Methods** is an interactive web application designed to make learning numerical analysis engaging and accessible.

---

##  Concept & Inspiration

The idea for *All The Methods* was born from a series of personal notes taken during a numerical analysis class. These notes captured the essence of various algorithms and their practical applications.

The app transforms that knowledge into an interactive learning experience, heavily inspired by platforms like **Leetcode**—but for math. Instead of coding problems, users solve mathematical problems using numerical techniques. The focus is on **individual progress**.

---

### Prerequisites
- Node.js 20+ & npm (for frontend)
- Java 25 & Maven (for backend)
- PostgreSQL 14+ (for database)


## Run the app without docker

1. **Clone the repository**
   ```bash
   git clone https://github.com/sotosAdis92/all-the-methods.git
   cd all-the-methods
   ```
   
- File → Open… → select server/pom.xml → "Open as Project"
- File → Project Structure → Project → set SDK to JDK 25 (download via SDKs →  Download JDK → 25 if needed) and Language level to 25.
The pom.xml is inside /server, not at the repository root. If you open the root, it will not be detected as a Spring Boot project.

# Run the Java server
```bash
export DB_URL=jdbc:postgresql://localhost:5432/solverAppDB
export DB_USERNAME=your_db_username
export DB_PASSWORD=your_db_password
export JWT_SECRET=your_jwt_secret

cd backend
mvn spring-boot:run
```

# Run the React.js client
```bash
cd frontend
npm install
npm start
```
