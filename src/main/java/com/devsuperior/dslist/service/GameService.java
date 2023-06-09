package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = new ArrayList<>();
        for (Game x : result) {
            GameMinDTO gameMinDTO = new GameMinDTO(x);
            dto.add(gameMinDTO);
        }
        return dto;
    }

    @Transactional
    public Optional<Game> findByIdGame(Long id){
        return gameRepository.findById(id);
    }

    @Transactional
    public List<GameMinDTO> findByList(Long listId){
       List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> list = new ArrayList<>();
        for (GameMinProjection x : result) {
            GameMinDTO gameMinDTO = new GameMinDTO(x);
            list.add(gameMinDTO);
        }
        return list;
    }
}
