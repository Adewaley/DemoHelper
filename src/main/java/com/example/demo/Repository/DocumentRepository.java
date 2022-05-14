package com.example.demo.Repository;

import com.example.demo.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
