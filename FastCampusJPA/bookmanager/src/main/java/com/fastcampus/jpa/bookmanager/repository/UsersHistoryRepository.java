package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.UsersHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.fastcampus.jpa.bookmanager.repository
 * fileName : UsersHistoryRepository
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성
 */
public interface UsersHistoryRepository extends JpaRepository<UsersHistory, Long> {
}
