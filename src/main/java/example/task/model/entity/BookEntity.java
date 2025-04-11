package example.task.model.entity;

import example.task.model.dto.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    private String bname;
    private String bwriter;
    private String bcontent;
    private String bpwd;

    public BookDto toBookDto(){
        return BookDto.builder()
                .bid(this.bid)
                .bname(this.bname)
                .bwriter(this.bwriter)
                .bcontent(this.bcontent)
                .bpwd(this.bpwd)
                .build();
    }
}


