package com.cardapio.cardapio.entities;

public record FoodResponseDTO(Long id, String title, String img, Double price) {


    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getImg(), food.getPrice());
    }




}
