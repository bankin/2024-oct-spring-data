package com.example.springintro.model.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
//    @JoinColumn(name = "custom_id")
//    @JoinTable(
//            name = "mapping_table_name",
//            joinColumns = @JoinColumn(name = "author_column_in_mapping", referencedColumnName = "id_column_authors"),
//            inverseJoinColumns = @JoinColumn(name = "book_column_in_mapping", referencedColumnName = "id_column_books")
//    )
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
