package SS6.model.dto.response;

import SS6.model.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse {

    private List<Patient> data;
    private int totalPage;
    private long totalElement;
    private int currentPage;

}
