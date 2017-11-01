package com.mm.repository;

public interface InMemoryRepository<T> {
    boolean add(T e);
    boolean contains(T e);
    boolean remove(T e);
    void clear();
}
