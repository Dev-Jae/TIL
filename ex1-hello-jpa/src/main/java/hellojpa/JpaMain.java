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
            // 영속
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");

            System.out.println("==================");

//            // JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.name = " + member.getName());
//            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
