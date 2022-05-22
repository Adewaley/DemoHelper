package com.example.demo.Repository;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByRole(Role role);

    Optional<User> findByName(String username);
}
