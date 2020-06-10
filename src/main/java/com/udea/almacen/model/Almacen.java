
package com.udea.almacen.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.udea.almacen.model.Producto;
import java.util.Collection;
import com.udea.almacen.model.Almacen;
import javax.persistence.OneToOne;
import org.springframework.lang.Nullable;

/**
 *
 * @author diego
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Toda la información de la entidad almacén")
@Entity
public class Almacen implements Serializable{
    
    @ApiModelProperty(notes = "ID generado automáticamente para la bd")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idalmacen")
    private Long idAlmacen;
    
    @ApiModelProperty(notes = "Ciudad donde está ubicado el almacén")
    @Column(name="ciudad", nullable=false, length=30)
    private @NonNull String ciudad;
    
    @ApiModelProperty(notes = "Almacen al que pertenecen los productos")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="idproducto",referencedColumnName="idproducto",nullable=false,unique=true) 
    private Producto producto; 
    
}