package mindswap.academy.SchoolProject.command.teacher;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.aspectj.bridge.IMessage;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Builder
public class CreateTeacherDto {

    @NotBlank(message = "name can't be null")
    private String name;
    @NotBlank(message = "subject can't be null")
    private String subject;
    @NotBlank(message = "password can't be blank")
    @Size(min=5, max=16, message = "password need to be at least 5 character and not longer than 16 characters")
    private String password;
}


