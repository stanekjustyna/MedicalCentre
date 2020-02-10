package js.project.MedicalCentre.model;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 8, message = "Username should contain at least 8 characters")
    private String username;

    @NotNull(message = "AcademicTitle cannot be null.")
    private AcademicTitle academicTitle;

    @NotBlank(message = "First name cannot be blank.")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank.")
    private String lastName;

    @Pattern(regexp = "^?([0-9]{3})?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{3})$", message = "Wrong mobile phone number format.")
    private String mobile;

    @Email
    @NotBlank(message = "Email cannot be blank.")
    private String email;

    @PESEL
    @NotBlank(message = "PESEL cannot be blank.")
    private String pesel;

    @NotBlank(message = "Medical licence cannot be blank.")
    @Pattern(regexp = "^\\d{7}$", message = "Medical licence number should contain 7 digits.")
    private String medical_licence;

    public Doctor() {
    }

    public Doctor(String username, AcademicTitle academicTitle, String firstName, String lastName, String mobile,
                  String email, String pesel, String medical_licence) {
        this.username = username;
        this.academicTitle = academicTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.pesel = pesel;
        this.medical_licence = medical_licence;
    }
}
