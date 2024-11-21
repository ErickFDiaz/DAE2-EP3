package pe.com.muertelenta.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;
import pe.com.muertelenta.entity.base.BaseEntity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "TipoPlatoEntity")
@Table(name = "tipoplato")
public class TipoPlatoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codtipp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

}