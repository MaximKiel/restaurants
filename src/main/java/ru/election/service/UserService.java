package ru.election.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.election.model.User;
import ru.election.repository.UserRepository;

import java.util.List;

import static ru.election.util.validation.ValidationUtil.*;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getWithEmail(String email) {
        Assert.notNull(email, "Email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id) != 0, id);
    }

    public User create(User user) {
        Assert.notNull(user, "User must not be null");
        return repository.save(user);
    }

    public void update(User user) {
        Assert.notNull(user, "User must not be null");
        checkNotFoundWithId(repository.save(user), user.id());
    }
}