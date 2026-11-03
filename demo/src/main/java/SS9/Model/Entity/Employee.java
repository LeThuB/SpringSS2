package SS9.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private  String fullName;
    private String email;
    private String phone;
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
