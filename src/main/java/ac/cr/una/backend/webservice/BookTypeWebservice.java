/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.AuthorDAOImpl;
import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.AuthorServiceImpl;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author luism
 */

@Path("booktypes")
public class BookTypeWebservice {
    
    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    
    @Context
    private UriInfo context;

    public BookTypeWebservice() {
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getByName(String name) {
        BookType bookType = null;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        
        bookType = bookTypeService.findByName(name);
        
        return bookType;
    }
    
    @DELETE
    @Path("/")
    public boolean deleteAll(){
        boolean result;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        
        result = bookTypeService.deleteAll();
        
        return result;
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType createAuthor(BookType bookType){
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        
        bookType = bookTypeService.save(bookType);
        
        return bookType;
    }
}
