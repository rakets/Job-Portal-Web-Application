# Job Portal Web Application

<p align="center">
    ![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
    ![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=for-the-badge&logo=apachemaven)
    ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4-green?style=for-the-badge&logo=springboot)
    ![MySQL](https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql)
    ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template-darkgreen?style=for-the-badge&logo=thymeleaf)
    ![HTML](https://img.shields.io/badge/HTML-5-E34F26?style=for-the-badge&logo=html5)
    ![CSS](https://img.shields.io/badge/CSS-3-1572B6?style=for-the-badge&logo=css3)
    ![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=for-the-badge&logo=javascript)
    ![Bootstrap](https://img.shields.io/badge/Bootstrap-5-7952B3?style=for-the-badge&logo=bootstrap)
</p>


**Job Portal Web Application** — this project is a website for finding a job.

---

## 📑 Table of Contents
* [Screenshots](#-screenshots)
* [Tech Stack](#-tech-stack)
* [How to Run the Project](#-how-to-run-the-project)
* [Project Structure](#-project-structure)
* [Database Structure](#-database-structure)

---

## 📸 Screenshots

### 🏠 Main Pages

<p align="center">
  <img src="./docs/Home Page.png" width="220"/>
  <img src="./docs/Login Page.png" width="220"/>
  <img src="./docs/Registation Page.png" width="220"/>
</p>

---

### 👔 Recruiter Profile

<p align="center">
  <img src="./docs/Recruiter Dashboard Page.png" width="220"/>
  <img src="./docs/Recruiter Job Details Page.png" width="220"/>
  <img src="./docs/Post New Job Page.png" width="220"/>
  <img src="./docs/Edit Recruiter Profile Data Page.png" width="220"/>
</p>

---

### 👤 Candidate Profile

<p align="center">
  <img src="./docs/Candidate Dashboard Page.png" width="220"/>
  <img src="./docs/Saved Job Page.png" width="220"/>
  <img src="./docs/Edit Candidate Profile Data Page.png" width="220"/>
  <img src="./docs/Candidate Job Details Page.png" width="220"/>
</p>

---

## 🏗 Tech Stack

* **Java:** 21
* **Spring Boot:** 3.4.10
* **Apache-Maven:** 4.0.0
* **Database:** MySQL
* **Frontend:** Thymeleaf, HTML, CSS, JavaScript, Bootstrap 

---

## 🚀 How to Run the Project

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/rakets/Job-Portal-Web-Application.git
    ```
2.  **Go to the project folder:**
    ```bash
    cd Job-Portal-Web-Application
    ```
3. **Set up and build a database:**
    ```bash
    Run sql script from ./docs/data_base_backup/sql_script_database.sql.
    Use localhost:3306 for database.
    ```
4.  **Build the project:**
    ```bash
    mvn clean install
    ```
5.  **Run the project:**
    ```bash
    mvn spring-boot:run
    ```
    The application will be available at `http://localhost:8080/`.

---

## 📂 Project Structure

<p align="center">
  <img src="./docs/project structure_1.png" width="230"/>
  <img src="./docs/project structure_2.png" width="230"/>
  <img src="./docs/project structure_3.png" width="230"/>
</p>

<p align="center">
  <img src="./docs/project structure_4.png" width="230"/>
  <img src="./docs/project structure_5.png" width="230"/>
  <img src="./docs/project structure_6.png" width="230"/>
</p>

<p align="center">
  <img src="./docs/project structure_7.png" width="230"/>
  <img src="./docs/project structure_8.png" width="230"/>
</p>

---

## 📂 Database structure
<p align="center">
  <a href="./docs/database structure.png">
    <img src="./docs/database structure.png" width="600"/>
  </a>
</p>
