package ru.election.util.validation;

import ru.election.model.BasedEntity;
import ru.election.util.exception.IllegalRequestDataException;
import ru.election.util.exception.NotFoundException;

public class ValidationUtil {

    public static <T> T checkNotFound(T object, String massage) {
        checkNotFound(object != null, massage);
        return object;
    }

    public static void checkNotFound(boolean found, String massage) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + massage);
        }
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id = " + id);
    }

    public static void checkNew(BasedEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalRequestDataException(entity + "must be new (id=null)");
        }
    }

    public static void assureIdConsistent(BasedEntity entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.id() != id) {
            throw new IllegalRequestDataException(entity + "must be with id=" + id);
        }
    }
}