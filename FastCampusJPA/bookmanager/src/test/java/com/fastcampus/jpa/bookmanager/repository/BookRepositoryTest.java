package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * packageName : com.fastcampus.jpa.bookmanager.repository
 * fileName : BookRepositoryTest
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/30            jae                   최초생성
 */
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setAuthor("패스트캠퍼스");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }
}
