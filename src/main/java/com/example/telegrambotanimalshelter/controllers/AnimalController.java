package com.example.telegrambotanimalshelter.controllers;

import com.example.telegrambotanimalshelter.model_services.AnimalService;
import com.example.telegrambotanimalshelter.models.Animal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Operation(
            summary = "Добавление животного",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Добавляемое животное"
            ),
            tags = "Animals"
    )
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    @Operation(
            summary = "Возвращает:\n" +
                    "1) Всех животных (параметры вводить не нужно)\n" +
                    "2) Животных из конкретного приюта\n" +
                    "3) Конкретного животного по имени",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Найденные животные"
                    )
            },
            tags = "Animals"
    )
    @GetMapping
    public ResponseEntity getAnimals(@Parameter(example = "Мурзик") @RequestParam(required = false, name = "Имя животного") String animalName,
                                     @Parameter(example = "Приют кошек / Приют собак") @RequestParam(required = false, name = "Тип приюта") String shelterType) {
        if (animalName != null && !animalName.isBlank() && shelterType == null) {
            return ResponseEntity.ok(animalService.getAnimalByName(animalName));
        }
        if (shelterType != null && !shelterType.isBlank() && animalName == null) {
            final Collection<Animal> allAnimalsByType = animalService.getAllAnimalsByType(shelterType);
            return ResponseEntity.ok(allAnimalsByType);
        }
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @Operation(
            summary = "Возвращает:\n" +
                    "1) Всех усыновленных животных (параметры вводить не нужно)\n" +
                    "2) Усыновленных животных из конкретного приюта",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Найденные животные"
                    )
            },
            tags = "Animals"
    )
    @GetMapping("/adopted")
    public ResponseEntity getAdoptedAnimal(@Parameter(example = "Приют кошек / Приют собак") @RequestParam(required = false, name = "Типа приюта") String shelterType) {
        if (shelterType != null && !shelterType.isBlank()) {
            return ResponseEntity.ok(animalService.getAllAdoptedAnimalsByType(shelterType));
        }
        return ResponseEntity.ok(animalService.getAllAdoptedAnimals());
    }

    @Operation(
            summary = "Изменение животного по ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Редактируемое животное"
            ),
            tags = "Animals"
    )
    @PutMapping
    public Animal updateAnimal(@PathVariable(name = "ID") Long id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    @Operation(
            summary = "Удаление животного по ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "При успешном удалении код 200"
                    )
            },
            tags = "Animals"
    )
    @DeleteMapping
    public void deleteAnimal(@PathVariable(name = "ID") Long id) {
        animalService.deleteAnimal(id);
    }
}
