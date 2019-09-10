package com.sutticket.sutticketmajor.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "ticketbooking")
public class TicketBooking{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "bookDate")
    private Date bookdate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Show.class)
    @JoinColumn(name = "SHOW_ID", insertable = true)
    private Show show;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Performance.class)
    @JoinColumn(name = "PERFORMANCE_ID", insertable = true)
    private Performance performance;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Seat.class)
    @JoinColumn(name = "SEAT_ID", insertable = true)
    private Seat seat;
    
    public TicketBooking(){}

}