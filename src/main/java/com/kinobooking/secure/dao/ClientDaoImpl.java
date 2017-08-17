package com.kinobooking.secure.dao;

import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.util.HibernateUtil;
import com.kinobooking.secure.validator.EmailExistsException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Locale;

/**
 * Created by Екатерина on 17.08.2017.
 */
@Repository
public class ClientDaoImpl implements ClientDao{
    @PersistenceContext
    private EntityManager entityManager;
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
    public void save(Client client){
        entityManager.persist(client);
    }

    @Transactional
    @Override
    public Client registerNewClientAccount(Client account) throws EmailExistsException {

        if (emailExist(account.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  account.getEmail());
        }
        save(account);
        return account;
    }

    private boolean emailExist(String email) {
        Client client = getClient(email);
        if (client != null) {
            return true;
        }
        return false;
    }
}
