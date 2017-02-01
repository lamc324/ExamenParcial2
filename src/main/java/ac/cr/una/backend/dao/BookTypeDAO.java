/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;

/**
 *
 * @author luism
 */
public interface BookTypeDAO {
    
    public boolean deleteAll();
    public BookType save(BookType bookType);
    public BookType findByName(String name);
    
}
