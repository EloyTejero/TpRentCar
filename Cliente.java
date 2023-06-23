package TpRentCar;

public class Cliente {
    int dni;
    String nombre;
    String direccion;
    int telefono;

    public Cliente(int dni, String nombre, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void mostrarDatos(){
        System.out.println("""
                           Cliente: 
                           \t dni = """ + dni + "\n\t nombre=" + nombre + "\n\t direccion =" + direccion + "\n\t telefono =" + telefono);
    }
    
    
}
