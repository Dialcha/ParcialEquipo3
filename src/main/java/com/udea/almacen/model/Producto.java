package com.udea.almacen.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Toda la información de la entidad producto")
@Entity
public class Producto implements Serializable{
    
    @ApiModelProperty(notes = "ID generado automáticamente para la bd")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idproducto")
    private Long idProducto;

    @ApiModelProperty(notes = "Nombre del producto")
    @Column(name="nombreproducto", nullable=false, length=30)
    private @NonNull String nombre;
            
    @ApiModelProperty(notes = "Cantidad de elementos en stock")
    @Column(name="stock", nullable=false, length=10)
    private @NonNull Integer stock;
    
    @OneToOne(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Almacen almacenes; 

}
