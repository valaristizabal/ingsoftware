package repository;
import dao.AbstractDao;

import java.util.List;

    public class EntityManager<T> {
        private final AbstractDao<T> dao;

        public EntityManager(AbstractDao<T> dao) {
            this.dao = dao;
        }

        public List<T> getAll() {
            return dao.getAll();
        }
    }


