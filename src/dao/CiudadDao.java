package dao;
import entidades.Ciudad;


    public class CiudadDao extends AbstractDao<Ciudad> {
        public CiudadDao() {
            super("ciudad.csv", Ciudad.class);
        }
    }

