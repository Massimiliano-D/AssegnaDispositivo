package massimiliano.AssegnaDispositivo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "utenti")
public class Utente {
    /* @OneToMany(mappedBy = "utente")
     @JsonIgnore
     List<Dispositivo> listaDispositivo;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String username;
    private String avatar;
}