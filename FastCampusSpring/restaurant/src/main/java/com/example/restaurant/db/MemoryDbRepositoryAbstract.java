package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T>{

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        // stream : 컬렉션에 저장되어 있는 요소들을 하나씩 참조하여 람다식으로 처리할 수 있도록 해주는 코트패턴
        // filter : 요소들을 조건에 따라 걸래는는 작업
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            // db에 이미 데이터가 있는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;

        } else {
            // db에 데이터가 없는 경우
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if(optionalEntity.isPresent()){
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
