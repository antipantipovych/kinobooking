package com.kinobooking.secure.service;

import com.kinobooking.secure.entity.Client;

/**
 * Created by Екатерина on 13.08.2017.
 */

public interface ClientService {
    public Client getClient(String login);
}
