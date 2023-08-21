package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.fastcampus.jpa.bookmanager.repository
 * fileName : UserRepository
 * author : jae
 * date  : 2023/08/21
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/21            jae                   최초생성
 */
public interface UserRepository extends JpaRepository<Users, Long> {
}
