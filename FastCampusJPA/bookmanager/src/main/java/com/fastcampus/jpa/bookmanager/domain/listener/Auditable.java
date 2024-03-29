package com.fastcampus.jpa.bookmanager.domain.listener;

import java.time.LocalDateTime;

/**
 * packageName : com.fastcampus.jpa.bookmanager.domain.listener
 * fileName : Auditable
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/30            jae                   최초생성
 */
public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
