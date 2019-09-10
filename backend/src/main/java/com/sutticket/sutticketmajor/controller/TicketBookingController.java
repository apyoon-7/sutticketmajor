package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Member;
import com.sutticket.sutticketmajor.entity.Performance;
import com.sutticket.sutticketmajor.entity.Seat;
import com.sutticket.sutticketmajor.entity.Show;
import com.sutticket.sutticketmajor.entity.TicketBooking;
import com.sutticket.sutticketmajor.repository.MemberRepository;
import com.sutticket.sutticketmajor.repository.PerformanceRepository;
import com.sutticket.sutticketmajor.repository.SeatRepository;
import com.sutticket.sutticketmajor.repository.ShowRepository;
import com.sutticket.sutticketmajor.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TicketBookingController {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PerformanceRepository performanceRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowRepository showRepository;

    @GetMapping("/ticketbooking/{id}")
    public TicketBooking getTicketBookingById(@PathVariable long id){
        Optional<TicketBooking> data  = ticketBookingRepository.findById(id);
        return data.get();
        
    }
    @GetMapping("/ticketBookings")
    public Collection<TicketBooking> getAllTicketBooking() {
        return ticketBookingRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/ticketBooking/{member_id}/{show_id}/{performance_id}/{seat_id}")
    public TicketBooking postTicketBooking(TicketBooking newTicketBooking, @PathVariable long member_id,
            @PathVariable long show_id, @PathVariable long performance_id, @PathVariable long seat_id) {

        Member member = memberRepository.findById(member_id);
        Show show = showRepository.findById(show_id);
        Performance performance = performanceRepository.findById(performance_id);
        Seat seat = seatRepository.findById(seat_id);

        newTicketBooking.setBookdate(new Date());
        newTicketBooking.setMember(member);
        newTicketBooking.setShow(show);
        newTicketBooking.setPerformance(performance);
        newTicketBooking.setSeat(seat);

        return ticketBookingRepository.save(newTicketBooking);

    }

    @DeleteMapping("/ticketbooking/{id}")
    public ResponseEntity<String> deleteTicketBooking(@PathVariable long id){
        ticketBookingRepository.deleteById(id);
        return new ResponseEntity<>("Ticketbooking" + id + "has been deleted!",HttpStatus.OK);
    }

}