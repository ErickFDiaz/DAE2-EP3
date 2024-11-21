package pe.com.muertelenta.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "PlatoEntity")
@Table(name = "plato")
public class PlatoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codplat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomplat")
    private String nombre;
    @Column(name = "desplat")
    private String descripcion;
    @Column(name = "preplat")
    private double precio;
    @Column(name = "canplat")
    private int cantidad;
    @Column(name = "estplat")
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "codtipp", nullable = false)
    private TipoPlatoEntity tipoplato;

}
