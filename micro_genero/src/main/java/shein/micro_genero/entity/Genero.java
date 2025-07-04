package shein.micro_genero.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "genero")
@Data
@Schema(description = "Entidad que representa un genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del genero", example = "1")
    private Integer idGenero;

    @Column(name = "nombre_genero", nullable = false)
    @NotBlank(message = "El nombre del genero es obligatorio")
    @Schema(description = "Nombre del genero", example = "Mujer")
    private String nombreGenero;
}
