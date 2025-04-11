package example.task.model.entity;

import example.task.model.dto.ReviewDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String rcontent;
    private String rpwd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private BookEntity bookEntity;

    public ReviewDto toReviewDto(){
        return ReviewDto.builder()
                .rid(this.rid)
                .rcontent(this.rcontent)
                .rpwd(this.rpwd)
                .bid(bookEntity.getBid())
                .build();
    }
}
