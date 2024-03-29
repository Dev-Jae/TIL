package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

/**
 * packageName : com.fastcampus.jpa.bookmanager.repository
 * fileName : UserRepositoryTest
 * author : jae
 * date  : 2023/08/21
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/21            jae                   최초생성
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;  // 의존성 추가

    @Autowired
    private UsersHistoryRepository usersHistoryRepository;

    @Test
    void usersHistoryTest(){
        Users users = new Users();
        users.setEmail("jae-new@gmail.com");
        users.setName("jae-new");

        userRepository.save(users);

        users.setName("jae-new-new");

        userRepository.save(users);

        usersHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void preUpdateTest(){
        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + users);

        users.setName("jae22");
        userRepository.save(users);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void prePersistTest(){
        Users users = new Users();
        users.setEmail("jae2@gmail.com");
        users.setName("jae");
//        users.setCreatedAt(LocalDateTime.now());
//        users.setUpdatedAt(LocalDateTime.now());

        userRepository.save(users);
        System.out.println(userRepository.findByEmail("jae2@gmail.com"));
    }

    @Test
    void listenerTest(){
        Users users = new Users();
        users.setEmail("jae2@gmail.com");
        users.setName("jae");

        userRepository.save(users);

        Users users2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users2.setName("jaaaaaaae");
        userRepository.save(users2);

        userRepository.deleteById(4L);
    }

    @Test
    void enumTest(){
        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users.setGender(Gender.MALE);

        userRepository.save(users);
        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));

    }

    @Test
    void insertAndUpdateTest(){
        Users users = new Users();
        users.setName("jae");
        users.setEmail("jae2@gmail.com");

        userRepository.save(users);

        Users users2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users2.setName("jaaaaae");

        userRepository.save(users2);

        System.out.println("user : " + userRepository.findAll());
    }

    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("jae"));

        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("jae"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("jae"));

        System.out.println("findFirstByName : " + userRepository.findFirstByName("jae", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));

        System.out.println("findByNameWithPaging : " + userRepository.findByName("jae", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }

    @Test
    void select(){
/*        System.out.println(userRepository.findByName("hyo"));

        System.out.println("findByEmail : " + userRepository.findByEmail("devhello940112@gmail.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("devhello940112@gmail.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("devhello940112@gmail.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("devhello940112@gmail.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("devhello940112@gmail.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("devhello940112@gmail.com"));
        System.out.println("findUsersByEmail : " + userRepository.findUsersByEmail("devhello940112@gmail.com"));
        System.out.println("====================");
        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("jae"));
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("jae"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("jae"));*/

        System.out.println("findMyEmailAndName : " + userRepository.findByEmailAndName("devhello940112@gmail.com", "jae"));
        System.out.println("findMyEmailOrName : " + userRepository.findByEmailOrName("devhello940112@gmail.com", "hyo"));
        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
        //System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressesIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("jae", "hyo")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("ja"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("ae"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("a"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%j%"));

    }

    @Test
    void crud(){    // create, read, update, delete

        /*
        // update
        userRepository.save(new Users("david", "david@gmail.com"));

        Users user = userRepository.findById(1L).orElse(null);
        user.setEmail("dev-update@gmail.com");

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

         */

        /*
        userRepository.findAll().forEach(System.out::println);
        ExampleMatcher matcher = ExampleMatcher.matching()  // 예제 엔터티 인스턴스를 기반으로 쿼리를 실행할 수있는 쿼리 생성 방법, SQL쿼리에서 LIKE와 같은 문이라 생각하면됨
                .withIgnorePaths("id")
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<Users> example = Example.of(new Users("ja", "naver.com"), matcher);
        userRepository.findAll(example).forEach(System.out::println);
        */

        /*
        // 페이징
        Page<Users> users = userRepository.findAll(PageRequest.of(0, 3));   // 페이지마다 몇개의 레코드
        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements());  // 총 갯수
        System.out.println("totalPages : " + users.getTotalPages());        // 총 페이지 수
        System.out.println("numberOfElements : " + users.getNumberOfElements());    // 현재 가져온 레코드 수
        System.out.println("sort : " + users.getSort());    // 정렬 적용 여부
        System.out.println("size : " + users.getSize());    // 페이징 시 몇개의 레코드로 나누고 있는지

        users.getContent().forEach(System.out::println);
         */


        /*
        // 삭제 후 조회 : delete는 먼저 select를 하여 존재하는지 확인 후 삭제,
        //userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));  // select가 두번 일어남
        //userRepository.deleteById(1L);  // select가 한번
        //userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L))); // 만개의 데이터가 있으면 delete가 만번 실행됨
        //userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));   // in으로 조회 후, delete시 or조건이 들어감
        userRepository.deleteAllInBatch();  // 사전 select 없이 바로 해당 테이블 데이터 삭제
        System.out.println("===============================");
        userRepository.findAll().forEach(System.out::println);
         */


        /*
        // exists
        boolean exists = userRepository.existsById(1L);
        System.out.println("exists : " + exists);
         */

        /*
        //count
        long count = userRepository.count();

        System.out.println("count : " + count);
         */

        /*
        userRepository.saveAndFlush(new Users("new jae", "newjae@gmail.com")); // flush : DB반영 시점을 조절
        userRepository.findAll().forEach(System.out::println);
         */

        /*
        // 조회 부분
        List<Users> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));   // 이름 기준 내림차순 정렬
        List<Users> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));     // Id 기준으로 조회

        users.forEach(System.out::println);
         */

        // 저장
        /*
        Users user1 = new Users("jack", "jack@gmail.com");
        Users user2 = new Users("steve", "steve@gmail.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));
        List<Users> users = userRepository.findAll();

        users.forEach(System.out::println);
         */

        /*
        Users user = userRepository.getOne(1L); // no session 오류가 남 : @Transactional 어노테이션을 붙여주면 동작함
        System.out.println(user);
         */

        /*
        Users user = userRepository.findById(1L).orElse(null);
        System.out.println(user);
         */

    }
}