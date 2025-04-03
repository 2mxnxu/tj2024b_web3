package example.day01._엔티티;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam2")
public class ExamEntity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = false)
    private String col1;

    @Column(nullable = false, unique = true)
    private String col2;

    @Column(columnDefinition = "longtext")
    private String col3;
    
    @Column(name = "제품명" , length = 30, insertable = true, updatable = true)
    private String col4;

    @Column private LocalDate col5;
    @Column private LocalDateTime col6;

}
