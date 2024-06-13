package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

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

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

//    public void changeTeam(Team team) {
//        this.team = team;
//
//        // 연관관계 편의 메소드
//        // 역방향(주인이 아닌 방향)만 연관관계 설정
//        team.getMembers().add(this);
//    }

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
