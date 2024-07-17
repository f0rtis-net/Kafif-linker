package com.kafif_linker.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "long_url", nullable = false)
    private String longUrl;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "expires_in", nullable = false)
    private Date expires_in;
}