package com.kinobooking.secure.service;

/**
 * Created by Екатерина on 13.08.2017.
 */

import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public Client getClient(String login){
        Client client= null;
       try {
           System.out.println("Hello");
           Locale.setDefault(Locale.ENGLISH);
           Session session = HibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Client where login = '" + login+"'");
           System.out.println(query);
           client = (Client) query.uniqueResult();
           System.out.println("Hello2");
           System.out.println("!" + client.getClientId() + " " + client.getLogin() + " " + client.getPassword());
           session.close();
       }
       catch (Exception e){
           e.printStackTrace();
       }
        return client;
    }

}
