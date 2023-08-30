package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.fastcampus.jpa.bookmanager.repository
 * fileName : BookRepository
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/30            jae                   최초생성
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
