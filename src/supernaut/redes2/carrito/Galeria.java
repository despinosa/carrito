/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supernaut.redes2.carrito;

import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;

/**
 *
 * @author supernaut
 */
public class Galeria extends javax.swing.JPanel {

    /**
     * Creates new form GaleriaPnl
     * @param productos
     */
    public Galeria(CliCarrito mainFrm) {
        this.mainFrm = mainFrm;
        productosPnl = new HashMap<>();
        initComponents(mainFrm.getInventario());
    }
    
    public Galeria(CliCarrito mainFrm, Map<Integer, Short> carrito) {
        this.mainFrm = mainFrm;
        productosPnl = new HashMap<>();
        initComponents(mainFrm.getInventario(), carrito);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(Map<Integer, Producto> productos) {
        BoxLayout layout;
        ProductoPnl productoPnl;
        
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        for(Integer key : productos.keySet()) {
            productoPnl = new ProductoPnl(productos.get(key), mainFrm);
            productosPnl.put(key, productoPnl);
            add(productoPnl);
        }
    }// </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(Map<Integer, Producto> productos,
                                Map<Integer, Short> carrito) {
        BoxLayout layout;
        ProductoPnl productoPnl;
        
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        for(Integer key : carrito.keySet()) {
            productoPnl = new ProductoPnl(productos.get(key), mainFrm,
                                          carrito.get(key));
            productosPnl.put(key, productoPnl);
            add(productoPnl);
        }
    }// </editor-fold>

    // Variables declaration - do not modify
    private CliCarrito mainFrm;
    private Map<Integer, ProductoPnl> productosPnl;
    // End of variables declaration
}
