package main.model.dao.impl;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import main.model.dao.LessonDAO;
import main.model.entity.Lesson;

/**
 *
 */

public class LessonDAOImpl implements LessonDAO {

    @Override
    public Collection<Lesson> getAll() {
        Set<Lesson> lessons = new HashSet<>();


        return lessons;
    }

    @Override
    public Lesson getById(Long id) {
        Lesson lesson = null;


        return lesson;
    }

    @Override
    public Long insert(Lesson entity) {
        long result = -1;

        return result;
    }

    @Override
    public void update(Lesson entity) {

    }

    @Override
    public void delete(Lesson entity) {

    }

}
