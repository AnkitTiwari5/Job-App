package com.example.spring_boot_rest.service;


import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.model.UserPrincipal;
import com.example.spring_boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     User user=  repo.findByUsername(username);
     if(user==null)
     {
         System.out.println("404");
         throw new UsernameNotFoundException("404");
     }

     return new UserPrincipal(user);
    }
}
