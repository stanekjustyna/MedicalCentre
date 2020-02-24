package js.project.MedicalCentre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Username must be provided.")
    @Size(min = 8, message = "Username should contain at least 8 characters")
    private String username;

    @NotNull(message = "AcademicTitle must be provided.")
    private AcademicTitle academicTitle;

    @NotBlank(message = "First name must be provided.")
    private String firstName;

    @NotBlank(message = "Last name must be provided..")
    private String lastName;

    @Pattern(regexp = "^?([0-9]{3})?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{3})$", message = "Wrong mobile phone number format.")
    private String mobile;

    @Email
    @NotBlank(message = "Email must be provided.")
    private String email;

    @PESEL
    @NotBlank(message = "PESEL must be provided.")
    private String pesel;

    @NotBlank(message = "Medical licence must be provided.")
    @Pattern(regexp = "^\\d{7}$", message = "Medical licence number should contain 7 digits.")
    @Column(unique = true)
    private String medical_licence;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Specialization> specializations;

    @ManyToMany
    @JoinTable(
            name = "doctor_localization",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "localization_id")
    )
    @JsonIgnore
    private List<Localization> localizations;

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
