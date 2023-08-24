package com.fastcampus.jpa.bookmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * packageName : com.fastcampus.jpa.bookmanager.domain
 * fileName : Address
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/24            jae                   최초생성
 */

@Entity
public class Address {

    @Id
    private Long id;
}
