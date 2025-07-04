package im.otpverification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <h2>UserDTO</h2>
 *
 * @author aek
 * <p>
 * Description:
 */
@Setter
@Getter
public class UserDTO {

    @NotNull
    @Size(min = 4, max = 24)
    @NotBlank(message = "username is mandatory")
    private String username;

    private String firstName;

    private String lastName;
    @Email
    @NotNull
    @NotBlank(message = "email is mandatory")
    private String email;

    @NotNull
    @Size(min = 10, max = 13)
    @NotBlank(message = "mobile number is mandatory")
    private String mobNumber;

    private List<GroupRoleDTO> roles;

}

