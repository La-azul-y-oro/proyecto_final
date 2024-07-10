package com.azulyoro.back.repository;

import com.azulyoro.back.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRwpository extends JpaRepository <Service, Long> {
}
