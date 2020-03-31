-- manager.sys_user definition

CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `gmt_create` datetime NOT NULL,
                            `gmt_modify` datetime NOT NULL,
                            `password` varchar(255) DEFAULT NULL,
                            `username` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;