package guru.springframework.sfgtrainingpetclinic.services.map;

import guru.springframework.sfgtrainingpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            object.setId(generateId());
            map.put(object.getId(), object);
        } else {
            throw new NullPointerException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long generateId() {
        if (map.keySet().isEmpty())
            return 1L;
        else
            return Collections.max(map.keySet()) + 1;
    }
}
