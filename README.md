# 🔐 Spring Boot Security — Production User Auth (DB Based)

This section covers **real-project production setup** for User Registration + Login using Spring Security + Database.

---

## 📂 What We Implement

✔ Store users in DB  
✔ Password hashed using BCrypt  
✔ Register API (no login required)  
✔ All other endpoints **require login**  
✔ Default Spring Login Page enabled `/login`

---

## How it is implemented in code
1. Created User Entity
2. Create repo
3. Create service
4. Password hashed using BCryptPasswordEncoder
5. Register API in controller (set password again after encoding it)
6. All other endpoints **require login**  

---
