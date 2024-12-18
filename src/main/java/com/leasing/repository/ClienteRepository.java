package com.leasing.repository;

import com.leasing.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByEmailAndPassword(String email, String password);
    
    @Query("SELECT c FROM Cliente c WHERE c.email = ?1")
    Optional<Cliente> findByEmail(String email);
}
