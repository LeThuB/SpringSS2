package SS3.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
  @NotNull(message = "ID không được để trống")
  @Positive(message = "ID phải lớn hơn 0")
   private long id ;
   private String name;
   private String email;


}
