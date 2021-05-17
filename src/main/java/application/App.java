package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int number = s.nextInt();
            System.out.println("Data de Check-in (dd/mm/aaaa): ");
            Date checkIn = sdf.parse(s.next());
            System.out.println("Data de Check-out (dd/mm/aaaa): ");
            Date checkOut = sdf.parse(s.next());

            Reservation reserva = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira as novas datas para atualizar a reserva:");
            System.out.println("Data de Check-in (dd/mm/aaaa): ");
            checkIn = sdf.parse(s.next());
            System.out.println("Data de Check-out (dd/mm/aaaa): ");
            checkOut = sdf.parse(s.next());

            reserva.updateDates(checkIn, checkOut);
            System.out.println("Reserva atualizada: " + reserva);
        } catch (ParseException e) {
            System.out.println("O formato da data inserida é inválido!");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }

        s.close();
    }
}
