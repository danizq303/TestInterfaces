package Colecciones;

import java.util.Objects;

public class Persona {
    String nombre;
    int edad;

    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public boolean equals(Object obj) {
        Persona p = (Persona) obj;
        return edad == p.edad && nombre.equals(p.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
