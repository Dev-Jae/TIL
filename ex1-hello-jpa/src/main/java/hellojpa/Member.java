package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

    public Member(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*
    private Integer age;

    @Enumerated(EnumType.STRING)        // @Enumerated : enum 타입 매핑
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)   // @Temporal : 날짜 타입 매핑 > 최신 버전은 localDate, localDateTime 사용 하면 됨
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob    // 필트 타입이 문자면 CLOB, 나머지는 BLOB
    private String description;

    @Transient  // 필드 매핑 X, 주로 메모리상에서만 임시로 어떤 값을 보관하고 싶을 때 사용
    private int temp;
     */


}
