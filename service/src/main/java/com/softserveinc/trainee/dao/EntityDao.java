package com.softserveinc.trainee.dao;

import com.softserveinc.trainee.entity.Entity;

import java.util.List;

/**
 * Created by vberv on 6/27/2016.
 */
public interface EntityDao {
    public Entity getEntity(String id);

    public Entity addEntity(Entity entity);

    public Entity updateEntity(Entity entity);

    public void deleteEntity(String id);

    public List<Entity> getAllEntity();
}
