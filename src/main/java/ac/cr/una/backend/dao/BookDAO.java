/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author luism
 */
public interface BookDAO {
    
    public boolean deleteAll();
    public Book save(Book book);
    public List<Book> findAll();
    
}
