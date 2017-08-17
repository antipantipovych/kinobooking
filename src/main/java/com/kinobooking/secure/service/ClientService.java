package com.kinobooking.secure.service;

import com.kinobooking.secure.dto.ClientDto;
import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.validator.EmailExistsException;

/**
 * Created by Екатерина on 13.08.2017.
 */

public interface ClientService {
    public Client getClient(String login);
    public Client save(ClientDto client);
    public Client registerNewUserAccount(ClientDto account) throws EmailExistsException;
}
