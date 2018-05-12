package ru.ska.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	private String publisher;
	
	@ManyToMany(cascade = 
        {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "author_book",
        joinColumns = 
            @JoinColumn(
                name = "book_id", 
                referencedColumnName = "id"
            )
        ,
        inverseJoinColumns = 
            @JoinColumn(
                name = "author_id", 
                referencedColumnName = "id"
            )
        
    )
	private Set<Author> authors = new HashSet<>();
}
