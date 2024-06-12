package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();   // ex) DB connection

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Movie movie = new Movie();
            movie.setDirector("AAA");
            movie.setActor("BBB");
            movie.setName("어벤져스");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Item findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static Member saveMember(EntityManager em) {
        Member member = new Member();
        member.setUsername("member1");

        em.persist(member);
        return member;
    }
}
