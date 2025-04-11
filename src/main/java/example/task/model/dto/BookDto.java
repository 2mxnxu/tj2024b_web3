package example.task.model.dto;

import example.task.model.entity.BookEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    @Id
    private int bid;
    private String bname;
    private String bwriter;
    private String bcontent;
    private String bpwd;

    public BookEntity toBookEntity() {
        return BookEntity.builder()
                .bid(this.bid)
                .bname(this.bname)
                .bwriter(this.bwriter)
                .bcontent(this.bcontent)
                .bpwd(this.bpwd)
                .build();
    }
}
