import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_siret", nullable = false)
    private Long numeroSiret;

    @NotBlank
    @Column(name = "forme_juridique", nullable = false)
    private String formeJuridique;

    @NotBlank
    @Column(name = "raison_sociale", nullable = false)
    private String raisonSociale;

    @NotBlank
    @Column(name = "adresse", nullable = false)
    private String adresse;

    @NotBlank
    @Column(name = "ville", nullable = false)
    private String ville;

    @NotNull
    @Column(name = "code_postal", nullable = false)
    private Integer codePostal;

    // Le téléphone du tuteur de l'étudiant dans l’entreprise
    @NotBlank
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @NotBlank
    @Column(name = "fax", nullable = false)
    private String fax;

    // Le numéro de téléphone de l’entreprise
    @NotBlank
    @Column(name = "contact", nullable = false)
    private String contact;

    // La personne joignable de l’entreprise
    @NotBlank
    @Column(name = "telephone_contact", nullable = false)
    private String telephoneContact;

    @NotBlank
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    public Entreprise(
            String formeJuridique,
            String raisonSociale,
            String adresse,
            String ville,
            Integer codePostal,
            String telephone,
            String fax,
            String contact,
            String telephoneContact,
            String email
    ) {
        this.formeJuridique = formeJuridique;
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.fax = fax;
        this.contact = contact;
        this.telephoneContact = telephoneContact;
        this.email = email;
    }
}
