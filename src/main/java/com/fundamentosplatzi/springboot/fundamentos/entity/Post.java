package com.fundamentosplatzi.springboot.fundamentos.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;
    @Column(name = "description",length = 255)
    private String description;

    @ManyToOne
    @JsonBackReference
    private User user;

    //Constructor vacio
    public Post() {
    }

    //Constructor con datos
    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

}
