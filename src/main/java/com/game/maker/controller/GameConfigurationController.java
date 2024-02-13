package com.game.maker.controller;

import com.game.maker.dto.GameConfigurationDTO;
import com.game.maker.dto.InGameAlternativeResponse;
import com.game.maker.dto.InGameQuestionAndAlternativesDTO;
import com.game.maker.dto.InGameSessionDTO;
import com.game.maker.service.GameConfigurationService;
import com.game.maker.service.GameplayService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/configuration")
public class GameConfigurationController {

    private final GameConfigurationService gameConfigurationService;

    @GetMapping
    public List<GameConfigurationDTO> findAll() {
       return gameConfigurationService.findAll();
    }

    @PostMapping("/save")
    public GameConfigurationDTO save(@RequestBody GameConfigurationDTO gameConfigurationDTO) {
        return gameConfigurationService.save(gameConfigurationDTO);
    }

    @GetMapping("/{id}")
    public GameConfigurationDTO findById(@PathVariable Long id) {
        return gameConfigurationService.findById(id);
    }

    @GetMapping("/{level}")
    public GameConfigurationDTO findByLevel(@PathVariable String level) {
        return gameConfigurationService.findByLevel(level);
    }

 }
