package shein.micro_talla.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "talla")
@Data
@Schema(description = "Entidad que representa una talla")
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la talla", example = "1")
    private Integer idTalla;

    @Column(name = "nombre_talla", nullable = false)
    @NotBlank(message = "El nombre de la talla es obligatorio")
    @Schema(description = "Nombre de la talla", example = "23, 24, S, M")
    private String nombreTalla;
}
