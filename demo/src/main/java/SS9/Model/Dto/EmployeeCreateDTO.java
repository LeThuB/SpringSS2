package SS9.Model.Dto;

import SS9.Model.Entity.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDTO {
    @NotBlank(message = "Ten khong duoc de trong")
    private  String fullName;

    @Email(message = "Email phai dung dinh dang")
    private String email;

    @Pattern(regexp = "^(03|05|07|08|09)[0-9]{8}$",message = "So dien thoai phai co 10 so va bat dau bang 03, 05, 07, 08 ,09")
    private String phone;

    @Min(5000000)
    private Double salary;

    @NotNull
    private Long departmentId;
}
