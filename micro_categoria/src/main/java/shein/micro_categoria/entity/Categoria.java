package shein.micro_categoria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "categoria")
@Data
@Schema(description = "Entidad que representa una categoría")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la categoría", example = "1")
    private Integer idCategoria;

    @Column(name = "nombre_categoria", nullable = false)
    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Schema(description = "Nombre de la categoría", example = "Ropa")
    private String nombreCategoria;
}
