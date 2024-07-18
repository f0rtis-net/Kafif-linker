package com.kafif_linker.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "url_entity", schema = "kafif_linker_v1")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_entity_seq")
    @SequenceGenerator(name = "url_entity_seq", sequenceName = "kafif_linker_v1.url_entity_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "long_url", nullable = false)
    private String longUrl;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "expires_in", nullable = false)
    private Date expiresIn;
}