package pe.com.muertelenta.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder 
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseEntity2 {
    @Column(name = "nombre")
    @NotEmpty
    private String nombre;
    @Column(name = "apellidopaterno")
    @NotEmpty
    private String apellidopaterno;
    @Column(name = "apellidomaterno")
    @NotEmpty
    private String apellidomaterno;
    @Column(name = "dni")
    @NotEmpty
    private String dni;
    @Column(name = "fechanacimiento")
    @NotEmpty
    private String fechanacimiento;
    @Column(name = "direccion")
    @NotEmpty
    private String direccion;
    @Column(name = "telefono")
    @NotEmpty
    private String telefono;
    @Column(name = "celular")
    @NotEmpty
    private String celular;
    @Column(name = "correo")
    @NotEmpty
    private String correo;
    @Column(name = "sexo")
    @NotEmpty
    private String sexo;
    @Column(name = "estado")
    @NotEmpty
    private boolean estado;
}
