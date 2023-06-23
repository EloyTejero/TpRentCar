package TpRentCar;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Reserva {
    static int totalId;
    Cliente cliente;
    int id;
    ArrayList<Auto>autosReservados;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    int cantDias;
    double totalReserva;

    public Reserva(Cliente cliente, LocalDate fechaFin) {
        this.autosReservados = new ArrayList<>();
        this.cliente = cliente;
        this.fechaFin = fechaFin;
        fechaInicio = LocalDate.now();
        id = totalId;
        totalId++;
        calcularCantidadDias();
    }

    public Reserva(Cliente cliente, int cantDias) {
        this.autosReservados = new ArrayList<>();
        this.cliente = cliente;
        this.cantDias = cantDias;
        fechaInicio = LocalDate.now();
        id = totalId;
        totalId++;
        calcularFechaFin();
    }
    
    public void agregarAuto(Auto auto){
        autosReservados.add(auto);
    }
    
    public double calcularTotalReserva(){
        for(Auto a: autosReservados){
            totalReserva += cantDias*a.getValorAlquilerPorDia();
        }
        
        return totalReserva;
    }
    
    private void calcularFechaFin(){     
        fechaFin = fechaInicio.plusDays(cantDias);
    }
    
    private void calcularCantidadDias(){
        cantDias = Period.between(fechaInicio, fechaFin).getDays();
    }
    
    public void generarComprobante(){
        System.out.println("Ticket: "+id);
        cliente.mostrarDatos();
        System.out.println("Autos reservados: "+autosReservados.size());
        for(Auto a: autosReservados){
            a.mostrarDatosAuto();
        }
        System.out.println("Precio de la reserva: "+calcularTotalReserva());
        System.out.println("Dia de devolución: "+fechaFin.getDayOfMonth()+"/"+fechaFin.getMonth()+"/"+fechaFin.getYear());
    }
}