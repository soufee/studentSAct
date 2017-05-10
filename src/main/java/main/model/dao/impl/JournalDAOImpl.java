package main.model.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import main.model.dao.JournalDAO;
import main.model.entity.Journal;


public class JournalDAOImpl implements JournalDAO {


    @Override
    public Collection<Journal> getAll() {
        Set<Journal> lessons = new HashSet<>();


        return lessons;
    }

    @Override
    public Journal getById(Long id) {
        Journal journal = null;


        return journal;
    }

    @Override
    public Long insert(Journal entity) {
        long result = -1;

        return result;
    }

    @Override
    public void update(Journal entity) {

    }

    @Override
    public void delete(Journal entity) {

    }

}
