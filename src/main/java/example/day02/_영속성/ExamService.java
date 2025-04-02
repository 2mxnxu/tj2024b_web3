package example.day02._영속성;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
@RequiredArgsConstructor
public class ExamService {
    @PersistenceContext
    private final EntityManager entityManager;
    public void get(){
        // 1. 비영속 상태 : (그냥) 자바 객체
        ExamEntity examEntity1 = new ExamEntity();
        examEntity1.setName("유재석");
        System.out.println("★비영속상태 : " + examEntity1);
        // 2. 영속 상태(Persistent)
        entityManager.persist(examEntity1);
        System.out.println("★영속상태(Persistent) : " + examEntity1);
    }
}
