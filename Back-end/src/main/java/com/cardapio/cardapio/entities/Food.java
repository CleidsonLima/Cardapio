package com.cardapio.cardapio.entities;

import com.cardapio.cardapio.controller.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity(name = "foods")
@Table(name = "foods")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String img;
    private Double price;

public Food(FoodRequestDTO data){
    this.img = data.img();
    this.price = data.price();
    this.title = data.title();
}
}
