package com.fastcampus.jpa.bookmanager.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * packageName : com.fastcampus.jpa.bookmanager.domain
 * fileName : MyEntityListener
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/30            jae                   최초생성
 */
public class MyEntityListener {
    @PrePersist
    public void prePersist(Object o){
        if(o instanceof Auditable){
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }

    }

    @PreUpdate
    public void preUpdate(Object o ){
        if(o instanceof Auditable){
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
