package fiados.com.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TradeBranchResponse {

    private String email;
    private String role;
    private String dni;

}
