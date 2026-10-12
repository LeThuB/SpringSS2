package SS4.Controller;

import SS3.service.AuthorService;
import SS4.Service.BookService;
import SS4.model.dto.BookRequest;
import SS4.model.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService  bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    //lay tat ca sach
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks()) ;
    }

    //lay theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id){
        Book book = bookService.getBookById(id);
        if(book != null){
            return  new ResponseEntity<>(book, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Khong tim thay sach",HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping
    public ResponseEntity<?>createBook(@RequestBody BookRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(request));
    }
}
