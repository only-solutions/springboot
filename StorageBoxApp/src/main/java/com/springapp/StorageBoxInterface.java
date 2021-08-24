package com.springapp;

import java.util.List;
import java.util.Optional;

public interface StorageBoxInterface {
        List<StorageBoxes> findAll(); //Note our findAll returns a List, not an Iterable

        void save(StorageBoxes be);

        Optional<StorageBoxes> findById(Long id);

        void delete(long id);
}
