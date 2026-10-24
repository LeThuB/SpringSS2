package SS8.SS82.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/math")
public class MathController {
    @GetMapping("/divide")
   public double divide(@RequestParam double a, @RequestParam double b){
       if (b==0 ){
           throw new ArithmeticException("Khong the chia hco 0 ");
       }
        return a / b;
    }
}
