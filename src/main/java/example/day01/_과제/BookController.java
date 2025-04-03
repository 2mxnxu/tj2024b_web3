package example.day01._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping
    public boolean post(@RequestBody BookEntity bookentity) {
        boolean result = bookService.post(bookentity);
        return result;
    }
    @GetMapping
    public List<BookEntity> get() {
        return bookService.get();
    }
    @PutMapping boolean put(@RequestBody BookEntity bookentity) {
        boolean result = bookService.put(bookentity);
        return result;
    }
    @DeleteMapping boolean delete(@RequestParam int id) {
        boolean result = bookService.delete(id);
        return result;
    }
}
