package com.hibernate.practice.hibernatepractice.entity;


import javax.persistence.*;

@Entity
@Table(name = "game")
public class VideoGame {

    // declare fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "developer")
    private String developer;

    @Column(name = "rating")
    private String rating;

    @Column(name = "price")
    private int price;


    public VideoGame() {

    }

    // set up constructor

    public VideoGame(String title, String developer, String rating, int price) {
        this.title = title;
        this.developer = developer;
        this.rating = rating;
        this.price = price;
    }


    // set getter/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    // set toString


    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", developer='" + developer + '\'' +
                ", rating='" + rating + '\'' +
                ", price=" + price +
                '}';
    }
}
