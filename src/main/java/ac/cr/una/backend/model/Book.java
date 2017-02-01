/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author luism
 */

@Entity
@Table(name = "book", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_book")})
public class Book {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_book", unique = true, nullable = false)
   
    private int idBook;
    
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;
    
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    @JoinColumn(name = "id_book_type", nullable = false)
    private BookType type;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "date_release", unique = true, nullable = false)
    private Calendar dateRelease;
    
    @Column(name = "price", unique = true, nullable = false)
    private float price;
}
