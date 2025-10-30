# 🎬 Movie Ticket Booking System with OTP Login (2FA via SMS)

## 📖 Project Overview
The **Movie Ticket Booking System** is a **full-stack web application** that allows users to register and log in using **mobile number OTP verification (Two-Factor Authentication)**.  
Users can browse movies, view details, and book tickets online, while admins can manage movies and bookings.

This project demonstrates:
- ✅ Full-stack development (React + Spring Boot + Oracle)
- ✅ Integration with external SMS API (Twilio)
- ✅ Secure OTP-based authentication
- ✅ RESTful microservice architecture (MVC)
- ✅ Real-time business logic for ticket booking

---

## 🧩 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Frontend** | React JS, JavaScript, HTML, CSS, Bootstrap |
| **Backend** | Spring Boot, Spring REST, Spring Data JPA |
| **Database** | Oracle (H2 for demo) |
| **Authentication** | OTP-based 2FA using Twilio SMS API |
| **Architecture** | MVC + REST |
| **Tools** | Spring Dev Tools, Maven, Postman, VS Code, Eclipse/IntelliJ |

---

## ⚙️ Features

### 👤 User Features
- Register with name, email, and phone number  
- Login using phone number + OTP (sent via SMS)  
- View all available movies  
- Book tickets and view booking history  

### 🧑‍💼 Admin Features
- Add / Edit / Delete movies  
- Manage users and bookings  
- View booking statistics  

---

## 🔐 OTP Login Flow
1. User enters **mobile number** and clicks **Send OTP**  
2. System generates a **6-digit OTP**  
3. OTP is sent to the mobile via **Twilio SMS API**  
4. User enters OTP and verifies  
5. On success → access granted  

---

## 🗂️ Project Structure

### Backend (`/backend`)

### Frontend (`/frontend`)

---

## 🧾 Database Tables (Oracle)

| Table | Columns |
|--------|----------|
| **users** | id, name, email, phone, role |
| **movies** | id, title, genre, rating, duration |
| **bookings** | id, user_id, movie_id, seat_no, booking_date |
| **otp_verification** | id, phone, otp, expiry_time |


