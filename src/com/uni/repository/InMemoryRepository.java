package com.uni.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository <T> implements CrudRepository <T> {
    /**
     * implementarea functiilor din interfata CrudRepository
     */

    protected List<T>  repoList;

    public InMemoryRepository(){
            this.repoList =new ArrayList<>();
    }

    @Override
    public T findOne(int id) {
        return this.repoList.get(id);
    }

    @Override
    public List<T> findAll() {
        return this.repoList;
    }

    @Override
    public T save(T entity) {
        this.repoList.add(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        this.repoList.remove(entity);
    }

}
