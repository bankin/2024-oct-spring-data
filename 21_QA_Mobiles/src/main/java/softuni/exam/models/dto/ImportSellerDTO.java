package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ImportSellerDTO {
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;
    private String lastName;
    private String personalNumber;

    public boolean isValid() {
        if (firstName.length() < 2 || firstName.length() > 30) {
            return false;
        }

        //....

        return true;
    }
}
