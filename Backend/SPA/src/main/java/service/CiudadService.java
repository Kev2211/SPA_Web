package service;


import model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import repository.CiudadRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CiudadService implements CiudadRepository{

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Ciudad> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Ciudad> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Ciudad> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Ciudad getOne(Long aLong) {
        return null;
    }

    @Override
    public Ciudad getById(Long aLong) {
        return null;
    }

    @Override
    public Ciudad getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Ciudad> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Ciudad> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Ciudad> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Ciudad> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ciudad> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Ciudad> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Ciudad, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Ciudad> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Ciudad> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Ciudad> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    @Override
    public List<Ciudad> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Ciudad entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ciudad> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Ciudad> findAll(Sort sort) {
        return ciudadRepository.findAll(sort);
    }

    @Override
    public Page<Ciudad> findAll(Pageable pageable) {
        return null;
    }
}
