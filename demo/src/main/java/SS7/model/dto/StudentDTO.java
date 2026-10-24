package SS7.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class StudentDTO {
    @NotBlank(message = "Ho ten khong duoc de trong")
    @Size(min = 5, max = 100, message = "Ho ten phai tu 5 - 100 ky tu ")
    private String fullName;

    @NotBlank(message = "Chuyen nganh khong duoc de trong")
    private String major;

    @Min(value = 18, message = "Sinh vien dai hoc phai tu 18 tuoi tro len ")
    private int age;

    @Min(value = 0,message = "Diem gpa phai trong khoang tu 0 - 10")
    @Max(value = 10,message = "Diem gpa phai trog khoang tu 0 - 10")
    private Double gpa;

    @Pattern(regexp = "^SV\\d{4}$", message = "Ma sinh vien phai co dang SVxxxx  ")
    private String studentCode;
}
