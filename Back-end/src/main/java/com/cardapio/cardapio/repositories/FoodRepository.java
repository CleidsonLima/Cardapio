package com.cardapio.cardapio.repositories;

import com.cardapio.cardapio.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long > {
}
