package com.hibernate.practice.hibernatepractice.dao;

import com.hibernate.practice.hibernatepractice.entity.VideoGame;

import java.util.List;

public interface VideoGameDao {

    public List<VideoGame> findAll();

    public VideoGame findById(int theId);

    public List<VideoGame> findByDev(String dev);

    public void save(VideoGame theVideoGame);

    public void deleteById(int theId);

}
