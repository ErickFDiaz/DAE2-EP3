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
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.com.muertelenta.entity.base.BaseEntity2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity extends BaseEntity2 implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "usuemp")
    @NotEmpty
    private String usuario;
    @Column(name = "claemp")
    @NotEmpty
    private String clave;
    @ManyToOne
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;
    @ManyToOne
    @JoinColumn(name = "codrol", nullable = false)
    private RolEntity rol;
}