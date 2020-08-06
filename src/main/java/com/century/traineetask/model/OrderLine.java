/*package com.century.traineetask.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDERLINES")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "good_id")
    private Long goodId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "good_id")
    Good good;

    private int count;

}
 */
