package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> list = new ArrayList<>();
        for (GameList x : result) {
            GameListDTO gameListDTO = new GameListDTO(x);
            list.add(gameListDTO);
        }
        return list;
    }

}
