package example.task.model.dto;

import example.task.model.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private int rid;
    private int bid;
    private String rcontent;
    private String rpwd;

    public ReviewEntity toReviewEntity(){
        return ReviewEntity.builder()
                .rid(this.rid)
                .rcontent(this.rcontent)
                .rpwd(this.rpwd)
                .build();
    }
}
