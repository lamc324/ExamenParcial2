/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author luism
 */
public interface AuthorService {
    
    public boolean deleteAll();
    public AuthorContact save(AuthorContact authorcontact);
    public List<AuthorContact> findAll();
    public Author findByName(String name);
}
