DROP TABLE IF EXISTS kafif_linker_v1.url_entity;

CREATE TABLE kafif_linker_v1.url_entity
(
    id         BIGSERIAL                   NOT NULL,
    long_url   VARCHAR(255)                NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    expires_in TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_url_entity PRIMARY KEY (id)
);