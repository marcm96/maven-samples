package com.mm.states;

import com.koloboke.collect.set.hash.HashObjSet;
import com.koloboke.collect.set.hash.HashObjSets;
import com.mm.repository.CollectionRepository;
import com.mm.repository.InMemoryRepository;
import com.mm.repository.Order;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
    HASH_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(HashSet::new);
        }
    },

    TREE_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(TreeSet::new);
        }
    },


    ARRAY_LIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(ArrayList::new);
        }
    },


    LINKED_LIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(LinkedList::new);
        }
    },


    CONCURRENT_HASH_MAP() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(() -> Collections.newSetFromMap(new ConcurrentHashMap<Order, Boolean>()));
        }

    },

    ECLIPSE_COLLECTION() {
        @Override
        public InMemoryRepository<Order> get() { return new CollectionRepository<>(FastList::new);}
    },

    KOLOBOKE_HASH_MAP() {
        @Override
        public InMemoryRepository<Order> get() {
            Set<Order> set = HashObjSets.newMutableSet();
            return new CollectionRepository<>(() -> Collections.synchronizedSet(set));
        }
    }
}

