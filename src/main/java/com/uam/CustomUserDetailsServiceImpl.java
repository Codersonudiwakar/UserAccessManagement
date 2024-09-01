package com.uam;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	  @Autowired
	    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new CustomUserDetailsImpl(user);
    }

}
