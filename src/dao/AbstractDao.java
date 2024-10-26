package dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

    public abstract class AbstractDao<T> {
        private final String filePath;
        private final Class<T> type;

        protected AbstractDao(String filePath, Class<T> type) {
            this.filePath = filePath;
            this.type = type;
        }

        public List<T> getAll() {
            List<T> entities = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Constructor<T> constructor = type.getConstructor();
                    T entity = constructor.newInstance();

                    Field[] fields = type.getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        fields[i].setAccessible(true);
                        fields[i].set(entity, parseFieldValue(fields[i].getType(), values[i]));
                    }
                    entities.add(entity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return entities;
        }

        private Object parseFieldValue(Class<?> fieldType, String value) {
            if (fieldType == int.class) {
                return Integer.parseInt(value);
            } else if (fieldType == double.class) {
                return Double.parseDouble(value);
            } else {
                return value;
            }
        }
    }


