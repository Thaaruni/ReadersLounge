package com.thaaru.book_network.security;

import com.thaaru.book_network.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//used to load user-specific data during authentication.
//Spring Security uses UserDetailsService to:
//Fetch a user from the database using a unique identifier (typically email or username)
//Return an object of type UserDetails
//Then Spring uses it to validate the password and assign roles
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
    }
}