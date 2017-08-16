package com.kinobooking.secure.service;

/**
 * Created by Екатерина on 13.08.2017.
 */

import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.util.HibernateUtil;
import com.kinobooking.secure.validator.EmailExistsException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
           Query query = session.createQuery("from Client where email = '" + login+"'");
           System.out.println(query);
           client = (Client) query.uniqueResult();
           System.out.println("Hello2");
           System.out.println("!" + client.getClientId() + " " + client.getEmail() + " " + client.getPassword());
           session.close();
       }
       catch (Exception e){
           e.printStackTrace();
       }
        return client;
    }

    @Override
    public Client save(Client client){
        Locale.setDefault(Locale.ENGLISH);
        Session session = HibernateUtil.getSessionFactory().openSession();
        long id= (long)session.save(client);
        session.flush();
        session.close();
        return client;
    }
    @Transactional
    @Override
    public Client registerNewUserAccount(Client account) throws EmailExistsException {

        if (emailExist(account.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  account.getEmail());
        }
        return save(account);
    }
    private boolean emailExist(String email) {
        Client client = getClient(email);
        if (client != null) {
            return true;
        }
        return false;
    }
}
