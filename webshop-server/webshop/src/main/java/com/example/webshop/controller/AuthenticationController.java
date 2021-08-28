package com.example.webshop.controller;

import com.example.webshop.mappers.UserMapper;
import com.example.webshop.model.Administrator;
import com.example.webshop.model.Authority;
import com.example.webshop.model.Person;
import com.example.webshop.model.User;
import com.example.webshop.model.dto.LoginDataDTO;
import com.example.webshop.model.dto.TokenDataDTO;
import com.example.webshop.model.dto.UserDTO;
import com.example.webshop.security.TokenUtils;
import com.example.webshop.service.AdministratorService;
import com.example.webshop.service.AuthorityService;
import com.example.webshop.service.CustomUserDetailsService;
import com.example.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorService adminService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public AuthenticationController() {
    }

    // Prvi endpoint koji pogadja korisnik kada se loguje.
    // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
    @PostMapping("/log-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDataDTO authenticationRequest,
                                                       HttpServletResponse response) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        Person person = (Person) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(person.getUsername(), person.getId(), person.getAuthorities().get(0).getAuthority()); // prijavljujemo se na sistem sa email adresom

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new TokenDataDTO(jwt));
    }

    // Endpoint za registraciju novog korisnika
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDTO userRequest) throws Exception {

        User existUser = this.userService.findByUsernameOrEmail(userRequest.getUsername(), userRequest.getEmail());
        Administrator existAdmin = this.adminService.findByUsernameOrEmail(userRequest.getUsername(), userRequest.getEmail());
        if (existUser != null || existAdmin != null) {
            return new ResponseEntity<>("Username or email already exists.", HttpStatus.BAD_REQUEST);
        }
        existUser = userMapper.toEntity(userRequest);
        existUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        int role = 2;
        List<Authority> auth = authorityService.findById(role);
        existUser.setAuthorities(auth);
        existUser.setVerified(true);

        User newUser = userService.registerUser(existUser);

        if (newUser == null) {
            return new ResponseEntity<>("Username or email already exists.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userMapper.toDTO(newUser), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') || hasRole('ROLE_USER')")
    public void updatedLoggedIn(String username, String password) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
