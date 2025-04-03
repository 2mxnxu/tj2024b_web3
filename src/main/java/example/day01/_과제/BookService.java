package example.day01._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookEntityRepository bookEntityRepository;

    public boolean post(BookEntity bookEntity) {
        BookEntity bookEntity2 = bookEntityRepository.save(bookEntity);
        return true;
    }
    public List<BookEntity> get() {
        List<BookEntity> bookEntities = bookEntityRepository.findAll();
        return bookEntities;
    }
    @Transactional
    public boolean put(BookEntity bookEntity) {
        Optional<BookEntity> optionalBookEntity = bookEntityRepository.findById(bookEntity.getId());
        if (optionalBookEntity.isPresent()) {
            BookEntity bookEntity1 = optionalBookEntity.get();
            bookEntity1.setName(bookEntity.getName());
            bookEntity1.setWriter(bookEntity.getWriter());
            bookEntity1.setPublisher(bookEntity.getPublisher());
            bookEntityRepository.save(bookEntity1);
            return true;
        }
        return false;
    }
    public boolean delete(int id) {
        bookEntityRepository.deleteById(id);
        return true;
    }
}
