package com.DOANJava.hotelmanage.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;


    @Column(name = "check_In")
    private LocalDate checkInDate;


    @Column(name = "check_Out")
    private LocalDate checkOutDate;


    @Column(name = "guest_FullName")
    private  String guestFullName;

    @Column(name = "guest_Email")
    private  String getGuestEmail;

    @Column(name = "adults")
    private  int NumOfAdults; //so nguoi lon

    @Column(name = "children")
    private  int Numofchildren; //so tre em

    @Column(name = "tatal_guest")
    private  int totalNumberofGuest;

    @Column(name = "confirmation_Code")
    private  String bookingConfirmationCode;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "room_id")

    @Column(name = "room_id")
    private Room room;

    public void caculateTotalNumberofGuest(){
        this.totalNumberofGuest= this.NumOfAdults+Numofchildren;
    };

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        caculateTotalNumberofGuest();
    }

    public void setNumofchildren(int numofchildren) {
        Numofchildren = numofchildren;
        caculateTotalNumberofGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}


