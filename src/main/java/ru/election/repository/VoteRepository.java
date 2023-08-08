package ru.election.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.election.model.Vote;

import java.util.List;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

    @Query("SELECT v FROM Vote v WHERE v.restaurant_id=:restaurantId AND v.user_id=:userId AND v.id=:id")
    Vote get(@Param("restaurantId") int restaurantId, @Param("userId") int userId, @Param("id") int id);

    @Query("SELECT v FROM Vote v WHERE v.restaurant_id=:restaurantId AND v.user_id=:userId")
    List<Vote> getAll(@Param("restaurantId") int restaurantId, @Param("userId") int userId);
}
