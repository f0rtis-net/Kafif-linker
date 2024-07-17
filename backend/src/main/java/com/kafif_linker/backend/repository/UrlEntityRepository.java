package com.kafif_linker.backend.repository;

import com.kafif_linker.backend.model.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlEntityRepository extends JpaRepository<UrlEntity, String>, JpaSpecificationExecutor<UrlEntity> {
}