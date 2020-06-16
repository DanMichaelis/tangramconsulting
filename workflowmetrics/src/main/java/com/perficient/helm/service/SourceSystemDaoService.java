package com.dtcc.workflowmetrics.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtcc.workflowmetrics.dao.SourceSystemDao;
import com.dtcc.workflowmetrics.entity.SourceSystem;

@Service
public class SourceSystemDaoService {

    @Autowired
    SourceSystemDao dao;

    public <S extends SourceSystem> S save(S entity) {
        return dao.save(entity);
    }

    public <S extends SourceSystem> Iterable<S> saveAll(Iterable<S> entities) {
        return dao.saveAll(entities);
    }

    public Optional<SourceSystem> findById(Integer id) {
        return dao.findById(id);
    }

    public boolean existsById(Integer id) {
        return dao.existsById(id);
    }

    public Iterable<SourceSystem> findAll() {
        return dao.findAll();
    }

    public Iterable<SourceSystem> findAllById(Iterable<Integer> ids) {
        return dao.findAllById(ids);
    }

    public long count() {
        return dao.count();
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public void delete(SourceSystem entity) {
        dao.delete(entity);
    }

    public void deleteAll(Iterable<? extends SourceSystem> entities) {
        dao.deleteAll(entities);
    }

    public void deleteAll() {
        dao.deleteAll();
    }

}
