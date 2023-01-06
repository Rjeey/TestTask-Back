package com.ecbrates.exchangeapi.repositories;


import com.ecbrates.exchangeapi.entity.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConversionRepository extends JpaRepository<Conversion, Long> {

    Optional<Conversion> findById(Long id);

    List<Conversion> findAllByUser_Id(Long id);

    List<Conversion> findAll();
}
