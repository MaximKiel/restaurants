package ru.election.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meal extends NamedEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    private String description;

    @NotNull
    private LocalDate date;

    @NotNull
    @Range(max = 10000)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public Meal(Integer id, String name, String description, LocalDate date, int price) {
        super(id, name);
        this.description = description;
        this.date = date;
        this.price = price;
    }
}
