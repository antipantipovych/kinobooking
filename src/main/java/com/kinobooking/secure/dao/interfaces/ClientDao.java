package com.kinobooking.secure.dao.interfaces;

import com.kinobooking.secure.dto.ClientDto;
import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.validator.EmailExistsException;

/**
 * Created by Екатерина on 17.08.2017.
 */

public interface ClientDao {

    void delete(Client client);
    Client save (ClientDto client) ;
    Client getClient(String login);
    Client registerNewClientAccount(ClientDto client)throws EmailExistsException;
}
