package shein.micro_color.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "color")
@Data
@Schema(description = "Entidad que representa un color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del color", example = "1")
    private Integer idColor;

    @Column(name = "nombre_color", nullable = false)
    @NotBlank(message = "El nombre del color es obligatorio")
    @Schema(description = "Nombre del color", example = "Rojo")
    private String nombreColor;
}
