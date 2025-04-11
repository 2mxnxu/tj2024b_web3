package example.task.service;

import example.task.model.dto.BookDto;
import example.task.model.entity.BookEntity;
import example.task.model.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookDto bookSave(BookDto bookDto) {
        BookEntity bookEntity = bookDto.toBookEntity();
        BookEntity saveEntity = bookRepository.save(bookEntity);
        if (saveEntity.getBid() > 0) {
            return saveEntity.toBookDto();
        }else {
            return null;
        }
    }
    public List<BookDto> bookFindAll() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (int i = 0; i < bookEntityList.size(); i++) {
            BookDto bookDto = bookEntityList.get(i).toBookDto();
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }
    public BookDto bookFindById(int bid) {
        Optional<BookEntity> optional = bookRepository.findById(bid);
        if (optional.isPresent()) {
            BookEntity bookEntity = optional.get();
            BookDto bookDto = bookEntity.toBookDto();
            return bookEntity.toBookDto();
        }
        return null;
    }
    public BookDto bookUpdate(BookDto bookDto){
        Optional<BookEntity> optional = bookRepository.findById(bookDto.getBid());
        if (optional.isPresent()) {
            BookEntity bookEntity = optional.get();
            bookEntity.setBname(bookDto.getBname());
            bookEntity.setBwriter(bookDto.getBwriter());
            bookEntity.setBcontent(bookDto.getBcontent());
            bookEntity.setBpwd(bookDto.getBpwd());
            return bookEntity.toBookDto();
        }
        return null;
    }
    public boolean bookDelete(int bid){
        boolean result = bookRepository.existsById(bid);
        if (result == true) {
            bookRepository.deleteById(bid);
            return true;
        }
        return false;
    }
}
