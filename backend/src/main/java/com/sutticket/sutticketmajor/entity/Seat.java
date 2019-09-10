package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "seat")
public class Seat{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SEAT_ID")
    private long id;
    private long seat_level = 0;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}