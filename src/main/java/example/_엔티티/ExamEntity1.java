package example._엔티티;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExamEntity1 { //클래스
    // 멤버변수
    @Id // 식별키(pk) 필수
    private int col1;
    private String col2;
    private double col3;
}
