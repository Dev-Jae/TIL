package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.UsersEntityListener;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName : com.fastcampus.jpa.bookmanager.domain
 * fileName : User
 * author : jae
 * date  : 2023/08/21
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/21            jae                   최초생성
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(value = {UsersEntityListener.class})
public class Users extends BaseEntity implements Auditable{
    @Id                 // PK 값
    @GeneratedValue     // JPA가 테이블의 기본키 값을 자동으로 생성해주는 어노테이션(자동생성 전략 지정)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(updatable = false)  // update시 할지 말지
    @CreatedDate
    private LocalDateTime createdAt;

/*    //@Column(insertable = false) // insert시 할지 말지
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Transient  // 영속성 처리 제외, DB데이터에 반영되지 않음
    private String testData;*/


//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> addresses;

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
