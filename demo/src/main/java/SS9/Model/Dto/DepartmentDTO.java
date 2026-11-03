package SS9.Model.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Ten khong duoc de trong ")
    @Size(min = 5 ,max = 50,message = "ten co do dai tu 5- 50 ky tu ")
    private String name;

@Size(max = 100, message = "Do dai toi da 100 ky tu ")
    private String description;
}
