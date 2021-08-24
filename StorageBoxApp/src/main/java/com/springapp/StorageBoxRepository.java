package com.springapp;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repo")
public interface StorageBoxRepository extends CrudRepository<StorageBoxes, Long> {
    //to debug verify spring.jpa.show-sql=true is in application.properties to see generated SQL
    //@Query(value = "SELECT NEW com.springapp.CountResult(MAX(storageboxes.id)) FROM com.springapp.BoxEntry boxentry")

    @Query(value = "SELECT NEW com.springapp.CountResult(MAX(storageboxes.myid)) FROM com.springapp.StorageBoxes storageboxes")
    CountResult getMaxId();

    @Override
    List<StorageBoxes> findAll();
}

