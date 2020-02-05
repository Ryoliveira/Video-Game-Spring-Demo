package com.hibernate.practice.hibernatepractice.dao;

import com.hibernate.practice.hibernatepractice.entity.VideoGame;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class VideoGameDaoImpl implements VideoGameDao {

    private EntityManager entityManager;

    @Autowired
    public VideoGameDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<VideoGame> findAll() {
        // Get session
        Session currentSession = entityManager.unwrap(Session.class);

        // Create query
        Query<VideoGame> theQuery = currentSession.createQuery("from VideoGame", VideoGame.class);

        // execute query
        List<VideoGame> games = theQuery.getResultList();

        return games;
    }

    @Override
    public VideoGame findById(int theId) {
        // Get current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create query
        Query<VideoGame> query = currentSession.createQuery("from VideoGame where id=:id", VideoGame.class)
                .setParameter("id", theId);

        // get result
        VideoGame result = query.getSingleResult();

        // return result
        return result;
    }

    @Override
    public List<VideoGame> findByDev(String dev) {
        // get current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create query
        Query<VideoGame> query =
                currentSession.createQuery("from VideoGame where developer=:devName", VideoGame.class)
                        .setParameter("devName", dev);

        // get result
        List<VideoGame> results = query.getResultList();

        // return result
        return results;
    }

    @Override
    public void save(VideoGame theVideoGame) {
        // get session
        Session currentSession = entityManager.unwrap(Session.class);

        // save object
        currentSession.saveOrUpdate(theVideoGame);

    }

    @Override
    public void deleteById(int theId) {
        // get current session
        Session currentSession = entityManager.unwrap(Session.class);

        VideoGame theGame = currentSession.get(VideoGame.class, theId);

        // delete object if not null
        currentSession.delete(theGame);

    }
}
