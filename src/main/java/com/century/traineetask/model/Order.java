package com.century.traineetask.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String client;
    private String date;
    private String address;

    //@OneToMany(mappedBy = "order")
    //Set<OrderLine> orderLines;

    public Order() {

    }

    public Order(String client, String date, String address) {
        this.client = client;
        this.date = date;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "client", nullable = false)
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Column(name = "date", nullable = false)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
