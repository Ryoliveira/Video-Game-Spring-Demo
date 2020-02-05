package com.hibernate.practice.hibernatepractice.service;

import com.hibernate.practice.hibernatepractice.dao.VideoGameDao;
import com.hibernate.practice.hibernatepractice.entity.VideoGame;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoGameService {

    private VideoGameDao videoGameDao;

    public VideoGameService(VideoGameDao theVideoGameDao) {
        videoGameDao = theVideoGameDao;
    }

    @Transactional
    public List<VideoGame> findAll() {
        List<VideoGame> gameList = videoGameDao.findAll();

        return gameList;
    }

    @Transactional
    public VideoGame findById(int theId) {
        VideoGame game = videoGameDao.findById(theId);

        return game;
    }

    @Transactional
    public List<VideoGame> findByDev(String dev) {
        List<VideoGame> games = videoGameDao.findByDev(dev);

        return games;
    }

    @Transactional
    public void save(VideoGame theGame) {
        videoGameDao.save(theGame);
    }

    @Transactional
    public void delete(int theId) {
        videoGameDao.deleteById(theId);
    }

}
