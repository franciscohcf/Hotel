package model.entities;

import model.exceptions.DomainException;
import model.exceptions.OccupationException;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private Integer occupation;
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(Integer occupation) {
        if (occupation > 1) {
            throw new OccupationException("O hotel possui apenas um quarto disponível");
        }
        this.occupation = occupation;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Reservation reserva) {
        rooms.add(new Room(reserva));
    }

    public void removeRoom(Reservation reserva) {
        rooms.remove(new Room(reserva));
    }
}
