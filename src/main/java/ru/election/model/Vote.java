package ru.election.model;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote extends BasedEntity {

    @NotNull
    private User user;

    @NotNull
    private Restaurant restaurant;

    @NotNull
    private LocalDateTime dateTime;

    public Vote(Integer id, User user, Restaurant restaurant, LocalDateTime dateTime) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.dateTime = dateTime;
    }
}
