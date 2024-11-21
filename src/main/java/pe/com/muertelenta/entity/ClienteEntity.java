package pe.com.muertelenta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.com.muertelenta.entity.base.BaseEntity2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity extends BaseEntity2 implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @ManyToOne
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;
}