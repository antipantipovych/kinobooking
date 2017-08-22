package com.kinobooking.secure.dao.implementations;

import com.kinobooking.secure.dao.interfaces.ClientDao;
import com.kinobooking.secure.dto.ClientDto;
import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.validator.EmailExistsException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Locale;

/**
 * Created by Екатерина on 17.08.2017.
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client getClient(String login){
        Client client= null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Client where email = '" + login+"'");
            client = (Client) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    @Transactional
    public void delete(Client client){entityManager.remove(client);}

    @Override
    @Transactional
    public Client save(ClientDto client){
        Client c= new Client(shaPasswordEncoder.encodePassword(client.getPassword(),""),client.getLastName(),client.getEmail(),client.getFirstName());
        try {
            Locale.setDefault(Locale.ENGLISH);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(c);
            session.flush();
            session.getTransaction().commit();
            System.out.println(client.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }

    @Transactional
    @Override
    public Client registerNewClientAccount(ClientDto account) throws EmailExistsException {

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
