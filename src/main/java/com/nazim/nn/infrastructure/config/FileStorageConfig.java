package com.nazim.nn.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {

    private String uploadDir;

    private String moveDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public String getMoveDir() {
        return moveDir;
    }

    public void setMoveDir(String moveDir) {
        this.moveDir = moveDir;
    }
}
