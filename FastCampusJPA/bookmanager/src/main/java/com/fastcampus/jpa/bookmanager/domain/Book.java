package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName : com.fastcampus.jpa.bookmanager.domain
 * fileName : Book
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/30            jae                   최초생성
 */
@Entity
@EntityListeners(value = MyEntityListener.class)
@NoArgsConstructor
@Data
public class Book implements Auditable{
    @Id
    @GeneratedValue // 생성된 값
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

/*    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }*/
}
