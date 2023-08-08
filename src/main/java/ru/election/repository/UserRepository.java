package ru.election.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.election.model.User;

import java.util.List;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User> {

    @Query("SELECT u FROM User u WHERE u.id=:id")
    User get(@Param("id") int id);

    @Query("SELECT * FROM User u")
    List<User> getAll();
}
