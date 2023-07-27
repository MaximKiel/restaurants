package ru.election.model;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
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
