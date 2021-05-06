package tn.esprit.consomitounsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import tn.esprit.consomitounsi.exception.AppException;
import tn.esprit.consomitounsi.modal.Role;
import tn.esprit.consomitounsi.modal.RoleName;
import tn.esprit.consomitounsi.modal.User;
import tn.esprit.consomitounsi.repository.RoleRepository;
import tn.esprit.consomitounsi.repository.UserRepository;
import tn.esprit.consomitounsi.security.JwtTokenProvider;
import tn.esprit.consomitounsi.security.LoginRequest;
import tn.esprit.consomitounsi.security.SignUpRequest;
import tn.esprit.consomitounsi.service.ApiResponse;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AuthenticationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("authority", authorities.toString());
        hmap.put("accessToken", jwt);
        return ResponseEntity.ok(hmap);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ApiResponse(false, "Username already used!"),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ApiResponse(false, "Email already used!"),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        User user = new User(signUpRequest.getFirstName(),signUpRequest.getLastName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPhone(signUpRequest.getPhone());
        user.setAddresse(signUpRequest.getAddresse());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setLastName(signUpRequest.getLastName());
        Role userRole ;
        if (signUpRequest.getRole().equals("ROLE_USER")) {
        	    userRole = roleRepository.findByName(RoleName.USER_ROLE)
                       .orElseThrow(() -> new AppException("User Role not set."));
        }else {
        	 userRole = roleRepository.findByName(RoleName.ADMIN_ROLE)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }
        
        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "You are successfully registered"));
    }
	
}
