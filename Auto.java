package TpRentCar;

public class Auto {
    int matricula;
    String modelo;
    String color;
    String marca;
    double valorAlquilerPorDia;

    public Auto(int matricula, String modelo, String color, String marca, double valorAlquilerPorDia) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.valorAlquilerPorDia = valorAlquilerPorDia;
    }

    
    public void mostrarDatosAuto() {
         System.out.println("Auto\n" + "\tmatricula =" + matricula + "\n\tmodelo =" + modelo + "\n\tcolor =" + color + "\n\tmarca =" + marca + "\n\tvalorAlquilerPorDia =" + valorAlquilerPorDia);
    }

    public double getValorAlquilerPorDia() {
        return valorAlquilerPorDia;
    }
    
    
}