package js.project.MedicalCentre.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Localization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Province must be provided.")
    private String province;

    @NotBlank(message = "City must be provided.")
    private String city;

    @NotBlank(message = "Street must be provided.")
    private String street;

    @NotBlank(message = "House number must be provided.")
    private String house_number;
    
    private String flat_number;

    private String office_number;

    private String guidance_notes;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Localization() {
    }

    public Localization(String province, String city, String street, String house_number,
                        String flat_number, String office_number, String guidance_notes) {

        this.province = province;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.flat_number = flat_number;
        this.office_number = office_number;
        this.guidance_notes = guidance_notes;
    }


}
