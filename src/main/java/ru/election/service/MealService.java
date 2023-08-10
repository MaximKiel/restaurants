package ru.election.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.election.model.Meal;
import ru.election.repository.MealRepository;
import ru.election.repository.RestaurantRepository;

import java.util.List;

import static ru.election.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;

    public MealService(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Meal get(int restaurantId, int id) {
        return checkNotFoundWithId(mealRepository.get(restaurantId, id), id);
    }

    public List<Meal> getAllByRestaurant(int restaurantId) {
        return mealRepository.getAllByRestaurant(restaurantId);
    }

    public List<Meal> getAll() {
        return mealRepository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(mealRepository.delete(id) != 0, id);
    }

    public Meal create(Meal meal, int restaurantId) {
        Assert.notNull(meal, "Meal must not be null");
        return save(meal, restaurantId);
    }

    public void update(Meal meal, int restaurantId) {
        Assert.notNull(meal, "Meal must not be null");
        checkNotFoundWithId(save(meal, restaurantId), meal.id());
    }

    private Meal save(Meal meal, int restaurantId) {
        if (!meal.isNew() && get(restaurantId, meal.id()) == null) {
            return null;
        }
        meal.setRestaurant(restaurantRepository.get(restaurantId));
        return mealRepository.save(meal);
    }
}