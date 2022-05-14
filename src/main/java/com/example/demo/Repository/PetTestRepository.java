package com.example.demo.Repository;
import com.example.demo.Entity.PetTest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PetTestRepository extends CrudRepository<PetTest, Long> {

    public List<PetTest> findById(int id);


}
