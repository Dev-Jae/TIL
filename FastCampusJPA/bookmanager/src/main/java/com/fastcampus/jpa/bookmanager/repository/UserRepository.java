package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    Set<Users> findByName(String name);

    Users findByEmail(String email);

    Users getByEmail(String email);

    Users readByEmail(String email);

    Users queryByEmail(String email);

    Users searchByEmail(String email);

    Users streamByEmail(String email);

    Users findUsersByEmail(String email);

    List<Users> findFirst1ByName(String name);
    List<Users> findTop1ByName(String name);

    List<Users> findLast1ByName(String name);

    List<Users> findByEmailAndName(String email, String name);

    List<Users> findByEmailOrName(String email, String name);

    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);

    List<Users> findByIdAfter(Long id);

    List<Users> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<Users> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tommorrow);

    List<Users> findByIdBetween(Long id1, Long id2);

    List<Users> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);


}

