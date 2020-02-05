package com.hibernate.practice.hibernatepractice.controller;

import com.hibernate.practice.hibernatepractice.entity.VideoGame;
import com.hibernate.practice.hibernatepractice.service.VideoGameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class VideoGameController {

    private VideoGameService videoGameService;

    public VideoGameController(VideoGameService theVideoGameService) {
        videoGameService = theVideoGameService;
    }

    @GetMapping("/api/games")
    public List<VideoGame> listGames() {
        List<VideoGame> games = videoGameService.findAll();

        return games;
    }

    @GetMapping("/api/games/{gameId}")
    public VideoGame getGame(@PathVariable("gameId") int gameId) {
        VideoGame theGame = videoGameService.findById(gameId);

        if (theGame == null) {
            throw new RuntimeException("Game not found with id - " + gameId);
        }

        return theGame;

    }

    @GetMapping("/api/dev/{developer}")
    public List<VideoGame> getDeveloperGames(@PathVariable("developer") String dev) {
        return videoGameService.findByDev(dev);
    }

    @PostMapping("/api/games")
    public VideoGame saveGame(@RequestBody VideoGame theGame) {

        theGame.setId(0);

        videoGameService.save(theGame);

        return theGame;
    }


    // add put mapping for update
    @PutMapping("/api/games")
    public VideoGame updateGame(@RequestBody VideoGame theGame) {

        videoGameService.save(theGame);

        return theGame;
    }


    // add DeleteMapping for delete
    @DeleteMapping("/api/games/{gameId}")
    public String deleteGame(@PathVariable("gameId") int gameId) {

        VideoGame theGame = videoGameService.findById(gameId);

        if (theGame == null) {
            throw new RuntimeException("Game not found with id - " + gameId);
        }
        videoGameService.delete(gameId);
        return "Deleted Game with id - " + gameId;
    }

}
