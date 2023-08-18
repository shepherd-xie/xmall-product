CREATE TABLE `tb_category`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`         varchar(255)    NOT NULL,
    `parent_id`    bigint unsigned          DEFAULT NULL,
    `parent`       tinyint(1)      NOT NULL,
    `sort`         int             NOT NULL,
    `created_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    KEY `idx_parent_id` (`parent_id`),
    KEY `idx_sort` (`sort`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `tb_sku`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `spu_id`       bigint unsigned NOT NULL,
    `title`        varchar(255)    NOT NULL,
    `price`        bigint unsigned NOT NULL,
    `saleable`     tinyint(1)      NOT NULL,
    `valid`        tinyint(1)      NOT NULL,
    `created_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX `idx_spu_id` (`spu_id`),
    INDEX `idx_saleable` (`saleable`),
    INDEX `idx_valid` (`valid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `tb_sku_images`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku_id`       bigint unsigned NOT NULL,
    `image_url`    varchar(255)    NOT NULL,
    `title`        varchar(255)             DEFAULT NULL,
    `desc`         varchar(255)             DEFAULT NULL,
    `created_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX `idx_sku_id` (`sku_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `tb_sku_params`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku_id`       bigint unsigned NOT NULL,
    `name`         varchar(255)    NOT NULL,
    `value`        varchar(255)             DEFAULT NULL,
    `created_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY `uk_sku_id_name` (`sku_id`, `name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `tb_spu`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`        varchar(255)    NOT NULL,
    `sub_title`    varchar(255)             DEFAULT NULL,
    `category_id`  bigint unsigned NOT NULL,
    `saleable`     tinyint(1)      NOT NULL,
    `valid`        tinyint(1)      NOT NULL,
    `created_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX `idx_category_id` (`category_id`),
    INDEX `idx_saleable` (`saleable`),
    INDEX `idx_valid` (`valid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

