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

## Run the app through Docker (Recommended approach)
```bash
git clone https://github.com/sotosAdis92/allTheMethods.git
cd spring-react
cp .env #fill in the values for db url, db username, db password, jwt token secret
docker compose up
```

## Run the app without docker

1. **Clone the repository**
   ```bash
   git clone https://github.com/sotosAdis92/allTheMethods.git
   cd spring-react
   ```
   
- File → Open… → select server/pom.xml → "Open as Project"
- File → Project Structure → Project → set SDK to JDK 25 (download via SDKs →  Download JDK → 25 if needed) and Language level to 25.
The pom.xml is inside /server, not at the repository root. If you open the root, it will not be detected as a Spring Boot project.

If you are getting an error for the lombok annotations, follow these steps:
- 1: Make sure lombok is in the pom.xml file
- 2: Open Intellij IDEA -> Plugins -> Make sure lombok is downloaded here
- 3: Open Intellij IDEA -> Settings -> Build, Execution Deployment -> Compiler -> Annotation Proccesor -> Select the file name of the project -> "Enable annotation processing" and "Obtain proccessors from project classpath"

# Run the Java server
```bash
export DB_URL=jdbc:postgresql://localhost:5432/solverAppDB
export DB_USERNAME=your_db_username
export DB_PASSWORD=your_db_password
export JWT_SECRET=your_jwt_secret

cd backend
mvn spring-boot:run
```

Java tomcat server runs by default on http://localhost:8080

# Run the React.js client
```bash
cd frontend
npm install
npm start
```
Vite server runs by default on http://localhost:5173

# Tech Stack

## Frontend
- ![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB) - Frontend Component Library
- ![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white) - Build Tool
- ![Material-UI](https://img.shields.io/badge/Material_UI-007FFF?style=for-the-badge&logo=mui&logoColor=white) - Frontend Component Library
- ![KaTeX](https://img.shields.io/badge/KaTeX-008080?style=for-the-badge&logo=katex&logoColor=white) - Frontend Styling Library
- ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) - Styling Language
- ![Axios](https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white) - Http Library
- ![React Router](https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white) - Routing
- ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) - Language


## Backend
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) - REST API Framework
- ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white) - JWT AUTH
- ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white) - Database Connectivity
- ![Apache Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) - Build Tool
- ![Bucket4j](https://img.shields.io/badge/Bucket4j-0052CC?style=for-the-badge&logo=java&logoColor=white) - Caching and Rate Limiting
- ![Exp4j](https://img.shields.io/badge/Exp4j-4A154B?style=for-the-badge&logo=java&logoColor=white) - Mathematical Expression Evaluation
- ![JUnit 5](https://maven-badges.herokuapp.com/maven-central/org.junit.jupiter/junit-jupiter-api/badge.svg) - Unit Testing
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) - Language

## Database
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) - Database

# Brief Project Structure
```
spring-react/
├── clientside/
│   ├── public/
│   |   ├── Components/
│   |   ├── assets/
│   |   ├── enviroment/
│   |   ├── hooks/
│   |   ├── service/
│   |   ├── App.css/
│   |   ├── App.jsx/
│   |   ├── main.jsx/
│   ├── src/
├── server/
|   ├── allTheMethods/src/main/java/com.example.allTheMethods/
│   |   ├── ast/
│   |   ├── controllers/
│   |   ├── dto/
│   |   ├── entity/
│   |   ├── enums/
│   |   ├── exception/
│   |   ├── mapper/
│   |   ├── repository/
|   |   ├── security/
│   |   ├── service/
│   |   ├── utils/
│   ├── resources/
|   ├── test/
```
# Key Features
- Personalized Experience
- Track individual progress
- Learn through problem solving
- Practice
- User friendly interface
- Json web token authentication
- Server side computation of results
- Rate Limiting to prevent against DDOS attacks
  
# License

This project is licensed under the MIT License. See the [LICENSE](LICENSE)
