package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "performance")
public class Performance{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERFORMANCE_ID")
    private long id;

    private String name; //เช้าสายบ่ายเย็น


    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}