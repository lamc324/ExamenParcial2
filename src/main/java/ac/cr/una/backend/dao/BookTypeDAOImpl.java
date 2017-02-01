/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luism
 */
public class BookTypeDAOImpl implements BookTypeDAO{
    
    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;
        List<BookType> bookType = new ArrayList<>();

        session.beginTransaction();
        bookType = session.createCriteria(BookType.class).list();
        session.delete(bookType);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }
    
    @Override
    public BookType findByName(String name) {
        BookType bookType = null;
        Query query = session.createQuery("from Author where name = :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            bookType = (BookType) query.list().get(0);
        }

        return bookType;
    }
}
