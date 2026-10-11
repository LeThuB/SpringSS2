package SS3.service;

import SS3.Repository.AuthorRepository;
import SS3.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//C1 constructor ij
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository){

        this.authorRepository = authorRepository;
    }

    //C2 field ij
//    @Autowired
//    private AuthorRepository authorRepository;

public List<Author> getAllAuthor(){
        return  authorRepository.findAll();
}

//cap nhat
    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public Author getAuthorById(long id){
        return authorRepository.findById(id);
    }

    public Author updateAuthor(long id, Author author ){
        Author check = authorRepository.findById(id);
        if (check != null){
            return authorRepository.updateAuthor(author);
        }
        return null;
    }
}
