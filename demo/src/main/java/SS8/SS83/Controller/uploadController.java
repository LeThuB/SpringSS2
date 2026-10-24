package SS8.SS83.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

@RestController
@RequestMapping("/api/files")
public class uploadController {
    private static  final String uploadFile = "uploads";
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file){
       try {
           String fileName = file.getOriginalFilename();
           if(fileName== null || fileName.length() == 0) {
               return new ResponseEntity<>("File khong hop le", HttpStatus.BAD_REQUEST);
           }

           fileName = Paths.get(fileName).getFileName().toString();

           String lowerName = fileName.toLowerCase(Locale.ROOT);
           if(!lowerName.endsWith(".png")&&!lowerName.endsWith(".jpg")){
               return new  ResponseEntity<>("CHi chap nhan file .png hoac jpg",HttpStatus.BAD_REQUEST);

           }
               Path uploadPath =  Paths.get(uploadFile);
               Files.createDirectories(uploadPath);
               Path filePath = uploadPath.resolve(fileName);
               Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);

           return new ResponseEntity<>("Upload thành công: " + fileName, HttpStatus.OK);

       }catch  (IOException e) {
           e.printStackTrace();
           return new ResponseEntity<>("Lỗi server: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

        }
