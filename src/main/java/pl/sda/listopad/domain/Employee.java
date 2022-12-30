package pl.sda.listopad.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Name should not be empty")
    private String surname;
    @Email(message = "Invalid e-mail")
    @NotEmpty(message = "E-mail should not be empty")
    private String email;
    private String pesel;
    @Range(min = 0, max = 150, message = "Age has to be between 0 and 150")
    @NotNull(message = "Age is required")
    @Digits(message = "Digits?", integer = 3, fraction = 0)
    private int age;
    @Enumerated(EnumType.STRING)
    private Sex sex;


}

enum Sex {
    M,F
}
