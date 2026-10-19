package SS6.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientRequestDto {

    private String patientCode;
    private String fullName;
    private String phone;
    private String address;

}
