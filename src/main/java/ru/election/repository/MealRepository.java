package ru.election.repository;

import ru.election.model.Meal;

import java.util.List;

public interface MealRepository extends BaseRepository<Meal> {

    Meal get(int id);

    List<Meal> getAll();
}
