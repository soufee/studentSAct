package main.model.dao.impl;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import main.model.dao.GroupDAO;
import main.model.entity.Group;

/**
 *
 */
public class GroupDAOImpl implements GroupDAO {

    @Override
    public Collection<Group> getAll() {
        Set<Group> groups = new HashSet<>();


        return groups;
    }

    @Override
    public Group getById(Long id) {
        Group group = null;

        return group;
    }

    @Override
    public Long insert(Group entity) {
        long result = -1;

        return result;
    }

    @Override
    public void update(Group entity) {

    }

    @Override
    public void delete(Group entity) {

    }

}
