package com.springapp;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//IMPORTANT: "repo" matches variable defined in StorageBoxService
@Repository("repo")
public interface StorageBoxRepository extends CrudRepository<StorageBoxes, Long> {
    //to debug verify spring.jpa.show-sql=true is in application.properties to see generated SQL
    //@Query(value = "SELECT NEW com.springapp.CountResult(MAX(storageboxes.id)) FROM com.springapp.BoxEntry boxentry")

    //JPQL.  Spring requires alias for DB table name, even if its the same
    //Note how Java fully qualified class name can be used in the JPQL
    @Query(value = "SELECT NEW com.springapp.CountResult(MAX(storageboxes.myid)) FROM com.springapp.StorageBoxes storageboxes")
    CountResult getMaxId();

    //IMPORTANT: override for findAll required here to fix incompatible types error.
    //by default it expects to return an Iterable, this changes it to List
    @Override
    List<StorageBoxes> findAll();
}

