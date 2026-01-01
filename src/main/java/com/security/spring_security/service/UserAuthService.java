// package com.security.spring_security.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Service;

// import com.security.spring_security.entity.UserAuthEntity;
// import com.security.spring_security.repository.UserAuthRepository;

// // ----------------------------------- WHY IMPLEMENT UserDetailsService?
// -----------------------------------
// // When a user tries to login, Spring Security internally calls
// `loadUserByUsername(username)`
// // to fetch the user details. But Spring doesn't know where our user is
// stored (DB / InMemory / etc).
// //
// // By implementing UserDetailsService, we tell Spring how to fetch the user
// from DB.
// // - This method must return a UserDetails object (username, password,
// roles).
// // - Without implementing this, Spring Security cannot authenticate users
// stored in DB.
// //
// // In short:
// // UserDetailsService acts as a bridge between Spring Security and our
// database.
// //
// ----------------------------------------------------------------------------------------------------------
// @Service
// public class UserAuthService implements UserDetailsService {

// @Autowired
// private UserAuthRepository repo;

// @Override
// public UserDetails loadUserByUsername(String username) throws
// UsernameNotFoundException {
// return repo.findByUsername(username)
// .orElseThrow(() -> new UsernameNotFoundException("User not found"));
// }

// public UserAuthEntity saveUser(UserAuthEntity user) {
// return repo.save(user);
// }
// }