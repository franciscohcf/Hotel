package model.entities;

import model.exceptions.DomainException;

public class Room {

    private Reservation reservation;

    public Room() {
    }

    public Room(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }
}
