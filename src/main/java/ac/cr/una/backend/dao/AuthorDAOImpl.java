/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luism
 */
public class AuthorDAOImpl implements AuthorDAO {

    
    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public Author findByName(String name) {
        Author author = null;
        Query query = session.createQuery("from Author where name = :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            author = (Author) query.list().get(0);
        }

        return author;
    }
}
