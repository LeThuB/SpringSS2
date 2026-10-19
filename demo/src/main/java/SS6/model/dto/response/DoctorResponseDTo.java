package SS6.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class DoctorResponseDTo {
    private String doctorCode;
    private String fullName;
    private String specialization;
    private int  experienceYears;

    public DoctorResponseDTo() {
    }

    public DoctorResponseDTo(String doctorCode, String fullName, String specialization, int experienceYears) {
        this.doctorCode = doctorCode;
        this.fullName = fullName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }
}
