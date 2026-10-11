package SS3.AuthorController;

import SS3.model.Author;
import SS3.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
//xem danh sach
    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAllAuthor();
    }

    //them moi
    @PostMapping
    public Author createAuthor(@Valid @RequestBody Author author){
        return authorService.createAuthor(author);
    }

    // tim kiem theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable long id){
        Author author  = authorService.getAuthorById(id);
        if(author == null){
            return ResponseEntity.status(404).body("Khong tim thay tac gia co ID "+ id);
        }
        return ResponseEntity.ok(author);
    }

// cap nhat
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable long id,@RequestBody Author author){
        Author found = authorService.updateAuthor(id, author);
        if(found == null){
         // new de tao doi tuong resEntity moi
           return new ResponseEntity<>("Khong tim thay tac gia co ID" + id, HttpStatus.NOT_FOUND);
//            return ResponseEntity.status(404).body("Khong tim thay tac gia co ID "+ id);
        }else {
            return ResponseEntity.ok(found);
        }


    }

}
