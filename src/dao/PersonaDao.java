package dao;
import entidades.Persona;

    public class PersonaDao extends AbstractDao<Persona> {
        public PersonaDao() {
            super("persona.csv", Persona.class);
        }
    }


