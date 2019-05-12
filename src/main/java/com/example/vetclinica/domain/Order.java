//package com.example.vetclinica.domain;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//    @Id
//    @Column(name = "idorder")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long order_id;
//
//    private String timestart;
//    private String timefinish;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private User id;
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee_id;
//
//    private String status;
//
//    @ManyToMany
//    @JoinTable(
//            name = "order_services",
//            joinColumns = {@JoinColumn(name = "idservice")},
//            inverseJoinColumns = {@JoinColumn(name = "idorder")}
//    )
//    private Set<Service> services = new HashSet<>();
//
//    public Order() {
//    }
//}
