package SS6.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDto {
    private String doctorCode;
    private String fullName;
    private String specialization;
    private int  experienceYears;
}
