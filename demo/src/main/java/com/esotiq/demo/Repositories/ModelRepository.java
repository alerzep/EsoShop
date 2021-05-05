package com.esotiq.demo.Repositories;

import com.esotiq.demo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
