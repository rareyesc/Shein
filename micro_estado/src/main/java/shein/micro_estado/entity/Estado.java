package shein.micro_estado.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "estado")
@Data
@Schema(description = "Entidad que representa un estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del estado", example = "1")
    private Integer idEstado;

    @Column(name = "nombre_estado", nullable = false)
    @NotBlank(message = "El nombre del estado es obligatorio")
    @Schema(description = "Nombre del estado", example = "Activo")
    private String nombreEstado;
}
