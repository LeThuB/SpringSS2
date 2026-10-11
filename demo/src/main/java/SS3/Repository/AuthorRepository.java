package SS3.Repository;

import SS3.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

 private List<Author> authors = new ArrayList<>();

 public AuthorRepository(){
     authors.add(new Author(1,"A","a@gmail.com"));
     authors.add(new Author(2,"B","b@gmail.com"));
     authors.add(new Author(3,"C","c@gmail.com"));
 }

 public List<Author> findAll(){
     return authors;
 }

 // phuong thuc luu author vao danh sach
    public void save(Author author){
     this.authors.add(author);
    }

    public Author findById(long id){
     for(Author a: authors){
         if(a.getId()== id){
             return a;
         }
     }
     return null;
    }
//  C2:    return   authors.stream().filter(
//                author -> author.getId()==id)
//                .findFirst().orElse(null);

    public Author updateAuthor(Author author){
     for (Author a: authors){
         if(a.getId()==author.getId()){
             a.setName(author.getName());
             a.setEmail(author.getEmail());
             return a;
         }
     }
     return null;
    }
}
