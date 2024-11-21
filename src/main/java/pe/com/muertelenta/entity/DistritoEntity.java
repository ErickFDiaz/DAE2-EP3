package pe.com.muertelenta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.com.muertelenta.entity.base.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "DistritoEntity")
@Table(name = "distrito")
public class DistritoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "coddis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

}