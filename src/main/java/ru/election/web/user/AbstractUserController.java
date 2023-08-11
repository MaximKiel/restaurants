package ru.election.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.election.model.User;
import ru.election.service.UserService;

import java.util.List;

import static ru.election.util.validation.ValidationUtil.assureIdConsistent;
import static ru.election.util.validation.ValidationUtil.checkNew;

public abstract class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    public User get(int id) {
        log.info("get {}", id);
        return userService.get(id);
    }

    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        return userService.getByEmail(email);
    }

    public List<User> getAll() {
        log.info("getAll");
        return userService.getAll();
    }

    public void delete(int id) {
        log.info("delete {}", id);
        userService.delete(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return userService.create(user);
    }

    public void update(User user, int id) {
        log.info("update {} with id {}", user, id);
        assureIdConsistent(user, id);
        userService.update(user);
    }
}
