package SS4.Service;

import SS3.Repository.AuthorRepository;
import SS4.Reponsitory.AuthorReponsitory;
import SS4.Reponsitory.BookReponsitory;
import SS4.model.dto.BookRequest;
import SS4.model.entity.Author;
import SS4.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookReponsitory bookReponsitory;
    public BookService(BookReponsitory bookReponsitory){
        this.bookReponsitory = bookReponsitory;
    }
    @Autowired
    private AuthorReponsitory authorReponsitory;
public ResponseEntity<?> addBook(BookRequest request){
    Author author = authorReponsitory.findById(request.getAuthorId()).orElse(null);
    if(author ==null){
        return new ResponseEntity<>("Tac gia khong ton tai", HttpStatus.BAD_REQUEST);
    }else {
        Book newBook = new Book();
        newBook.setAuthor(author);
        newBook.setTitle(request.getTitle());
        newBook.setPrice(request.getPrice());
        return new ResponseEntity<>(bookReponsitory.save(newBook),HttpStatus.CREATED);

    }
}

public List<Book> findAllBooks(){
    return bookReponsitory.findAll();

}

public Book getBookById(Long id){
    return bookReponsitory.findById(id).orElse(null);
}

}
