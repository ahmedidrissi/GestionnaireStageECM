import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    
    @Column(name = "forme_juridique", nullable = false)
    private String formeJuridique;

    
    @Column(name = "raison_sociale", nullable = false)
    private String raisonSociale;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    
    @Column(name = "ville", nullable = false)
    private String ville;


    @Column(name = "code_postal", nullable = false)
    private Integer codePostal;

    // Le téléphone du tuteur de l'étudiant dans l’entreprise

    @Column(name = "telephone", nullable = false)
    private String telephone;

    
    @Column(name = "fax", nullable = false)
    private String fax;

    // Le numéro de téléphone de l’entreprise
    
    @Column(name = "contact", nullable = false)
    private String contact;

    // La personne joignable de l’entreprise
    
    @Column(name = "telephone_contact", nullable = false)
    private String telephoneContact;

   
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
