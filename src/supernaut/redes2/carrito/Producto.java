/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supernaut.redes2.carrito;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author supernaut
 */
public class Producto implements Serializable {
    private static final short W = 256;
    private static final short H = 256;
    private String nombre;
    private String descripcion;
    private float precio;
    private short disponibilidad;
    private List<Icon> imagenes;

    public Producto(String nombre, String descripcion, float precio,
                    short disponibilidad, List<String> rutasImg) {
        int i;
        Image imagen;
        Graphics2D g;
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.imagenes = new ArrayList<>();
        for(String rutaImg : rutasImg) {
            try {
                File f = new File(rutaImg);
                if(!f.exists()) {
                    System.out.println("El archivo no existe");
                    continue;
                }
                imagenes.add(new ImageIcon(ImageIO.read(f).
                             getScaledInstance(W, H, Image.SCALE_DEFAULT)));
            } catch (IOException ex) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,
                                                               null, ex);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if(!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if(!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if(Float.floatToIntBits(this.precio) !=
                Float.floatToIntBits(other.precio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Float.floatToIntBits(this.precio);
        return hash;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public short getDisponibilidad() {
        return disponibilidad;
    }

    public List<Icon> getImagenes() {
        return imagenes;
    }

    public void setDisponibilidad(short disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
