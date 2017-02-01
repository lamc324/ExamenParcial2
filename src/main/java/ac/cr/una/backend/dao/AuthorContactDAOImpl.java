/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author luism
 */
public class AuthorContactDAOImpl implements AuthorContactDAO{

    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;
        List<AuthorContact> authorContact = new ArrayList<>();

        session.beginTransaction();
        authorContact = session.createCriteria(AuthorContact.class).list();
        for (AuthorContact t : authorContact) {
            session.delete(t);
            isDeleted = true;
        }
        session.getTransaction().commit();

        return isDeleted;
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();

        return authorContact;
    }

    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> authorContact = new ArrayList<>();

        authorContact = session.createCriteria(AuthorContact.class).list();

        return authorContact;
    }
    
}
