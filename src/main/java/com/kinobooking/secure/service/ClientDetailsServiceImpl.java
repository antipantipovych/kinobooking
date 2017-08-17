package com.kinobooking.secure.service;

import com.kinobooking.secure.dto.ClientDto;
import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.entity.enums.UserRoleEnum;
import com.kinobooking.secure.validator.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Екатерина on 13.08.2017.
 */
@Service
public class ClientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        Client client = clientService.getClient(email);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(client.getEmail(),
                        client.getPassword(),roles);

        return userDetails;
    }

    public Client createUserAccount(ClientDto account, BindingResult result) {
        Client registered = null;
        try {
            System.out.println(account.toString());
            registered = clientService.registerNewUserAccount(account);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}




