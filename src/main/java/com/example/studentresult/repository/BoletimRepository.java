package com.example.studentresult.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentresult.model.Boletim;

public interface BoletimRepository extends JpaRepository<Boletim, Long> {

}
