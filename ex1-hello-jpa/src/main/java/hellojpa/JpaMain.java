package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //등록
            /*
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            // 조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            // 수정
            findMember.setName("HelloJPA");

            // JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                            .setFirstResult(5)
                                    .setMaxResults(8)
                                            .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");


            //영속
            Member member1 = new Member(150L, "A");

            // 플러시
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();
            System.out.println("==============");

            //준영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member);
            */
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
