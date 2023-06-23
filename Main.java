package TpRentCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto(0, "812 superfast", "negro", "ferrari", 1000.0));
        autos.add(new Auto(1, "duna", "rojo", "fiat", 200.0));

        Cliente cliente = agregarCliente();
        Reserva reserva = digitarDiaReserva(cliente);
        digitarReserva(autos, reserva);

    }

    private static void digitarReserva(List<Auto> autos, Reserva reserva) {
        System.out.println("");
        System.out.println("cuantos autos quiere reservar");
        int cantAutos = entrada.nextInt();
        for (int i = 0; i < cantAutos; i++) {
            System.out.println("digite la matricula del carro ");
            for (Auto a : autos) {
                a.mostrarDatosAuto();
            }
            int auto = entrada.nextInt();
            reserva.agregarAuto(autos.get(auto));
        }
        System.out.println("");
        reserva.generarComprobante();
    }

    private static Cliente agregarCliente() {
        System.out.println("digite su dni");
        int dni = entrada.nextInt();
        entrada.nextLine();
        System.out.println("ingrese su nombre");
        String nombre = entrada.next();
        System.out.println("ingrese su direccion");
        String direccion = entrada.next();
        System.out.println("ingrese su telefono");
        int telefono = entrada.nextInt();
        Cliente cliente = new Cliente(dni, nombre, direccion, telefono);

        return cliente;
    }

    private static Reserva digitarDiaReserva(Cliente cliente) {
        Reserva reserva = null;
        System.out.println("1- digitar los dias de fin, 2- digitar fecha de fin ");
        int opc = entrada.nextInt();
        entrada.nextLine();
        if (opc == 1) {
            System.out.println("digite los dias");
            int cantDias = entrada.nextInt();
            reserva = new Reserva(cliente, cantDias);
        }
        if (opc == 2) {
            System.out.println("digite dia");
            int dia = entrada.nextInt();
            entrada.nextLine();
            System.out.println("digite mes");
            int mes = entrada.nextInt();
            entrada.nextLine();
            System.out.println("digite año");
            int año = entrada.nextInt();
            LocalDate d = LocalDate.of(año, mes, dia);
            reserva = new Reserva(cliente, d);
        }
        return reserva;

    }
}