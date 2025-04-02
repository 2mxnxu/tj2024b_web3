package example.day02._BaseTime;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// - 모든 DB테이블의 레코드 생성날짜와 수정날짜를 감지하는 엔티티
@MappedSuperclass // 해당 클래스는 일반 엔티티가 아닌 상속엔티티로 사용 한다.
@EntityListeners(AuditingEntityListener.class) // 해당 클래스의 멤버들은 JPA 감지 대상
@Getter
public class BaseTime {

    // 1. 엔티티/레코드 의 영속/생성 날짜/시간 자동 주입
    @CreatedDate
    private LocalDateTime 생성날짜시간;
    
    // 2. 엔티티/레코드 의 수정 날짜/시간 자동 주입
    @LastModifiedDate
    private LocalDateTime 수정날짜시간;
}
