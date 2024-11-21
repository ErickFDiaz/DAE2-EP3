package pe.com.muertelenta.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder //herncia
@MappedSuperclass //mapeo de clases
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseEntity {

    @Column(name = "nombre", length = 50, nullable = false)
    @NotEmpty
    private String nombre;
    @Column(name = "estado", nullable = false)
    private boolean estado;
}
