package example.task.controller;

import example.task.model.dto.BookDto;
import example.task.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookDto bookSave(@RequestBody BookDto bookDto) {
        return bookService.bookSave(bookDto);
    }
    @GetMapping
    public List<BookDto> bookFindAll(){
        return bookService.bookFindAll();
    }
    @GetMapping("/view")
    public BookDto bookFindById(@RequestParam int bid) {
        return bookService.bookFindById(bid);
    }
    @PutMapping
    public BookDto bookUpdate(@RequestBody BookDto bookDto) {
        return bookService.bookUpdate(bookDto);
    }
    @DeleteMapping
    public boolean bookDelete(@RequestParam int bid){
        return bookService.bookDelete(bid);
    }
}
