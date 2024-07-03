package com.azulyoro.back.repository;

import com.azulyoro.back.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository <Pay, Long> {
}
