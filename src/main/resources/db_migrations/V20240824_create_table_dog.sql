CREATE TABLE IF NOT EXISTS dog (
    id             BIGINT       NOT NULL AUTO_INCREMENT comment 'id identifiery for this table',
    created_at     TIMESTAMP(3) NOT NULL comment 'this column is updated whenever row is created',
    updated_at     TIMESTAMP(3) NOT NULL ON UPDATE CURRENT_TIMESTAMP(3) comment 'this column is updated whenever row is created or updated',
    deleted_at     TIMESTAMP(3) NULL comment 'this column is set to indicate if row is not used anymore (soft delete)',
    racial         VARCHAR(255) NOT NULL comment 'the racial of the dog',
    color          VARCHAR(255) NOT NULL comment 'the color of the dog',
    PRIMARY KEY (`id`),
    KEY `dog_updated_at_idx` (`updated_at`),
    KEY `dog_created_at_idx` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;