CREATE TABLE IF NOT EXISTS person (
    `id`   BIGINT         NOT NULL AUTO_INCREMENT comment 'id identifier for this table',
    `name` VARCHAR(255)   NOT NULL comment 'the person name',
    `age`  INT            NOT NULL comment 'the person age',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;