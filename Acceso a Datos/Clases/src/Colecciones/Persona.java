package Colecciones;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public boolean equals(Object obj) {
        Persona p = (Persona) obj;
        return edad == p.edad && nombre.equals(p.nombre);
    }

    public int hashCode() {
        return nombre.hashCode() + edad * 1000;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
