package com.exam10.service;

import com.exam10.model.Role;
import com.exam10.model.User;
import com.exam10.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        roles.add("Пользователь");
        return roles;
    }



    public void updateUser(int id, String userRole, String fullName, String email){
        if(userRepository.existsById(id)){
            Set<Role> roles = getRole(userRole);
            var user = userRepository.findById(id);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setRoles(roles);
            userRepository.save(user);

        }
    }

    private Set<Role> getRole(String user_role){
        Set<Role> roles = new HashSet<>();
        if(user_role.equals("Пользователь")){
            roles.add(Role.USER);
        }
        return roles;
    }
}
