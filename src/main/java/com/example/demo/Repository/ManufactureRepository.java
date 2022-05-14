package com.example.demo.Repository;

import com.example.demo.Entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
}
