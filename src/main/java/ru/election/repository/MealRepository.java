package ru.election.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.election.model.Meal;

import java.util.List;

@Transactional(readOnly = true)
public interface MealRepository extends BaseRepository<Meal> {

    @Query("SELECT m FROM Meal m WHERE m.restaurant_id=:restaurantId AND m.id=:id")
    Meal get(@Param("restaurantId") int restaurantId, @Param("id") int id);

    @Query("SELECT m FROM Meal m WHERE m.restaurant_id=:restaurantId")
    List<Meal> getAll(@Param("restaurantId") int restaurantId);
}
