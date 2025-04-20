package com.cardapio.cardapio.controller;

import com.cardapio.cardapio.entities.Food;
import com.cardapio.cardapio.entities.FoodResponseDTO;
import com.cardapio.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAll() {
        try {
            List<FoodResponseDTO> foodList = repository.findAll().stream()
                    .map(FoodResponseDTO::new)
                    .toList();
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Caso haja erro ao buscar os dados
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO data) {
        try {
            Food foodData = new Food(data);
            repository.save(foodData);
            return new ResponseEntity<>("Item adicionado com sucesso!", HttpStatus.CREATED); // Retorna status 201 para criação
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar o item.", HttpStatus.BAD_REQUEST); // Erro no envio dos dados
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public ResponseEntity<String> updateFood(@RequestBody FoodRequestDTO data) {
        try {
            Food foodData = new Food(data);
            repository.save(foodData);
            return new ResponseEntity<>("Item atualizado com sucesso!", HttpStatus.OK); // Retorna status 200 para sucesso
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o item.", HttpStatus.BAD_REQUEST); // Erro no envio dos dados
        }
    }
}
