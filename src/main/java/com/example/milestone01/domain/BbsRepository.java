package com.example.milestone01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BbsRepository extends JpaRepository<Bbs,Long> {
    List<Bbs> findAllByOrderByCreatedAtDesc();
}
