package ru.election.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.election.model.Vote;
import ru.election.repository.RestaurantRepository;
import ru.election.repository.UserRepository;
import ru.election.repository.VoteRepository;

import java.util.List;

import static ru.election.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public VoteService(VoteRepository voteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public Vote get(int restaurantId, int userId, int id) {
        return checkNotFoundWithId(voteRepository.get(restaurantId, userId, id), id);
    }

    public List<Vote> getAllByRestaurantAndUser(int restaurantId, int userId) {
        return voteRepository.getAllByRestaurantAndUser(restaurantId, userId);
    }

    public List<Vote> getAllByRestaurant(int restaurantId) {
        return voteRepository.getAllByRestaurant(restaurantId);
    }

    public List<Vote> getAllByUser(int userId) {
        return voteRepository.getAllByUser(userId);
    }

    public List<Vote> getAll() {
        return voteRepository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(voteRepository.delete(id) != 0, id);
    }

    public Vote create(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "Vote must not be null");
        return save(vote, restaurantId, userId);
    }

    public void update(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "Vote must not be null");
        checkNotFoundWithId(save(vote, restaurantId, userId), vote.id());
    }

    private Vote save(Vote vote, int restaurantId, int userId) {
        if (!vote.isNew() && get(restaurantId, userId, vote.id()) == null) {
            return null;
        }
        vote.setRestaurant(restaurantRepository.get(restaurantId));
        vote.setUser(userRepository.get(userId));
        return voteRepository.save(vote);
    }
}