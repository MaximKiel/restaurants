package ru.election.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meal extends NamedEntity {

    @NotNull
    private LocalDate date;

    @NotNull
    @Range(max = 10000)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public Meal(Integer id, String name, LocalDate date, int price) {
        super(id, name);
        this.date = date;
        this.price = price;
    }
}
