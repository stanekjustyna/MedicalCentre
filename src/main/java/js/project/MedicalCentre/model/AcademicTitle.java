package js.project.MedicalCentre.model;

public enum AcademicTitle {
    DR("Physician"),
    MD("Doctor of Medicine"),
    PROF("Professor of Medicine");

    private String description;

    AcademicTitle(String description) {
        this.description = description;
    }
}
