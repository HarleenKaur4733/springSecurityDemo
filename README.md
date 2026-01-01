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

## Spring Security Architecture:
1. Request first pass through filters before reaching controller.
2. Filter that intercept request related to authentication is Authentication Filter.
3. Create **authentication object** from that.
4. Authenticate manager decides what to do with these credentials.He delegates request to suitable authentication provider.
5. Authentication provider is someone who authenticate your request. For that it needs two things:
     - Password Encoder
     - UserDetailService
6. Once authentication is confirmed by authentication provider, then **authentication object** is populated with more values like roles.
7. This **authentication object** is passed to Authentication Filter again by Authentication manager.
8. Then this **authentication object** resides inside _SecurityContext_ that can be used throughout the requests.

<img width="676" height="676" alt="image" src="https://github.com/user-attachments/assets/776d8300-03e8-4439-a809-1cc49273d71e" />
