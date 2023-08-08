package ru.election.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.election.model.User;
import ru.election.repository.UserRepository;

import java.util.List;

import static ru.election.util.validation.ValidationUtil.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(int id) {
        return checkNotFoundWithId(userRepository.get(id), id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(userRepository.delete(id) != 0, id);
    }

    public User createOrUpdate(User user) {
        Assert.notNull(user, "User must not be null");
        return userRepository.save(user);
    }
}