package com.leasing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leasing.models.Veiculo;

@Repository
public interface VehicleRepository extends JpaRepository<Veiculo, Long> {


}
