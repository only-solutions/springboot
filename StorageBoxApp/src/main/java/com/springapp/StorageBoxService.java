package com.springapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//IMPORTANT: "service" matches variable defined in StorageBoxApplication
@Service("service")
@Transactional
public class StorageBoxService implements StorageBoxInterface {
    @Autowired
    private StorageBoxRepository repo;

    @Override
    public List<StorageBoxes> findAll()
    {
        return repo.findAll();
    }

    @Override
    public void save(StorageBoxes boxdetails) {
        System.out.println("Box field 1: "+boxdetails.getCategory());
        System.out.println("Box field 2: "+boxdetails.getFolder());
        System.out.println("Box field 3: "+boxdetails.getTags());
        System.out.println("Box field ID: "+boxdetails.getId());
        System.out.println("Box field MyID: "+boxdetails.getMyid());

        repo.save(boxdetails);
    }

    @Override
    public Optional<StorageBoxes> findById(Long id) {
        if (repo.findById(id).isPresent())
            return Optional.of(repo.findById(id).get());
        else
            return Optional.empty();
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    public Integer getMaxId() {
        Integer maxid;
        maxid=repo.getMaxId().getCountval();
        if (maxid == null) {
            System.out.println("Max ID is null, set to 0");
            maxid=0;
        }
        return maxid;
    }

}