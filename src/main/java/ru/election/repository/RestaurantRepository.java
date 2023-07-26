package ru.election.repository;

import org.springframework.data.jpa.repository.Query;
import ru.election.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends BaseRepository<Restaurant> {

    Restaurant get(int id);

    List<Restaurant> getAll();
}
