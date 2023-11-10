package massimiliano.AssegnaDispositivo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dispositivi")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String stato;
    private int tempoDiassegnazione;
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
}