package ru.election.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.election.model.Meal;
import ru.election.service.MealService;

import java.net.URI;
import java.util.List;

import static ru.election.util.validation.ValidationUtil.assureIdConsistent;
import static ru.election.util.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = MealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {

    static final String REST_URL = "/admin/restaurant/meals";
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

//    TODO
//    Delete restaurants here because we already know  which restaurant the meal belongs to.

    @GetMapping("/{restaurantId}/{id}")
    public Meal get(@PathVariable int restaurantId, @PathVariable int id) {
        log.info("get meal with id {} by restaurant with id {}", id, restaurantId);
        return mealService.get(restaurantId, id);
    }

    @GetMapping("/{restaurantId}")
    public List<Meal> getAllByRestaurant(@PathVariable int restaurantId) {
        log.info("getAll by restaurant with id {}", restaurantId);
        return mealService.getAllByRestaurant(restaurantId);
    }

    @GetMapping
    public List<Meal> getAll() {
        log.info("getAll");
        return mealService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        mealService.delete(id);
    }

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> create(@RequestBody Meal meal, @PathVariable int restaurantId){
        log.info("create meal {} by restaurant with id {}", meal, restaurantId);
        checkNew(meal);
        Meal created = mealService.create(meal, restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(meal);
    }

    @PutMapping(value = "/{restaurantId}/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Meal meal, @PathVariable int restaurantId, @PathVariable int id) {
        log.info("update meal {} with id {} by restaurant with id {}", meal, id, restaurantId);
        assureIdConsistent(meal, id);
        mealService.update(meal, restaurantId);
    }
}