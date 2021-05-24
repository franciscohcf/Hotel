package application;

import model.entities.Hotel;
import model.entities.Reservation;
import model.exceptions.DomainException;
import model.exceptions.OccupationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("O hostel no momento possui apenas um quarto disponível");
        System.out.println();
        try {
            System.out.print("Quantas novas reservas vão ser adicionadas?");
            int occupation = s.nextInt();
            Hotel hostel = new Hotel(occupation);
            System.out.print("Número do quarto: ");
            int roomNumber = s.nextInt();
            System.out.println("Data de Check-in (dd/mm/aaaa): ");
            Date checkIn = sdf.parse(s.next());
            System.out.println("Data de Check-out (dd/mm/aaaa): ");
            Date checkOut = sdf.parse(s.next());

            Reservation reserva = new Reservation(roomNumber, checkIn, checkOut);
            hostel.addRoom(reserva);
            System.out.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Deseja modificar a reserva (s/n)?");

            char a = s.next().charAt(0);

            if(a=='s'){
                hostel.removeRoom(reserva);
                System.out.println();
                System.out.println("Insira as novas datas para atualizar a reserva:");
                System.out.println("Data de Check-in (dd/mm/aaaa): ");
                checkIn = sdf.parse(s.next());
                System.out.println("Data de Check-out (dd/mm/aaaa): ");
                checkOut = sdf.parse(s.next());
                reserva.updateDates(checkIn, checkOut);
                hostel.addRoom(reserva);
            }

            System.out.println("Reserva atualizada: " + reserva);
        } catch (ParseException e) {
            System.out.println("O formato da data inserida é inválido!");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (OccupationException e) {
            System.out.println("Ocupação máxima atingida: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        } finally {
            s.close();
        }

        s.close();
    }
}
