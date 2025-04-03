package example.day01._과제;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name = "book")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private int publicationYear;
}
