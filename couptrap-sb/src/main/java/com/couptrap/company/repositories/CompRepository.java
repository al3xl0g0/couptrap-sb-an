package com.couptrap.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.couptrap.company.models.Comp;

public interface CompRepository extends JpaRepository<Comp, Long> {

}
