package Colecciones;

public class Persona2 implements Comparable <Persona2>{
    private String nombre;
    private int edad;

    public Persona2(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public int compareTo(Persona2 o) {
        int r = 0;

        return 0;
    }
}
