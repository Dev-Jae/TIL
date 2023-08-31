package com.fastcampus.jpa.bookmanager.domain.listener;

import com.fastcampus.jpa.bookmanager.domain.Users;
import com.fastcampus.jpa.bookmanager.domain.UsersHistory;
import com.fastcampus.jpa.bookmanager.repository.UsersHistoryRepository;
import com.fastcampus.jpa.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * packageName : com.fastcampus.jpa.bookmanager.domain.listener
 * fileName : UsersEntityListener
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성
 */
public class UsersEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(Object o){
        UsersHistoryRepository usersHistoryRepository = BeanUtils.getBean(UsersHistoryRepository.class);

        Users users = (Users) o;
        UsersHistory usersHistory = new UsersHistory();

        usersHistory.setUserId(users.getId());
        usersHistory.setName(users.getName());
        usersHistory.setEmail(users.getEmail());

        usersHistoryRepository.save(usersHistory);
    }
}
