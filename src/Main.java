import dao.PersonaDao;
import dao.CiudadDao;
import entidades.Ciudad;
import entidades.Persona;
import repository.EntityManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Prueba con Persona
        EntityManager<Persona> personaManager = new EntityManager<>(new PersonaDao());
        List<Persona> personas = personaManager.getAll();
        System.out.println("Personas: ");
        personas.forEach(System.out::println);

        // Prueba con Ciudad
        EntityManager<Ciudad> ciudadManager = new EntityManager<>(new CiudadDao());
        List<Ciudad> ciudades = ciudadManager.getAll();
        System.out.println("Ciudades: ");
        ciudades.forEach(System.out::println);
    }
}
