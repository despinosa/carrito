/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supernaut.redes2.carrito;

import java.util.List;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author supernaut
 */
public class ProductoPnl extends javax.swing.JPanel {

    /**
     * Creates new form ProductoPnl
     * @param producto
     */
    public ProductoPnl(Producto producto, CliCarrito mainFrm) {
        this.producto = producto;
        this.mainFrm = mainFrm;
        initComponents();
        if(producto.getImagenes().size() >= 1) {
            imgSiguiente.setEnabled(false);
            imgAnterior.setEnabled(false);
        }
    }
    
    public ProductoPnl(Producto producto, CliCarrito mainFrm, short cantidad) {
        this.producto = producto;
        this.mainFrm = mainFrm;
        initComponents();
        if(producto.getImagenes().size() >= 1) {
            imgSiguiente.setEnabled(false);
            imgAnterior.setEnabled(false);
        }
        this.cantidad.setValue((int) cantidad);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagen = labelImg();
        imgAnterior = new javax.swing.JButton();
        imgSiguiente = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        cantidad = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1, 0, producto.getDisponibilidad(), 1));
        cambia = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setMaximumSize(new java.awt.Dimension(256, 256));
        imagen.setMinimumSize(new java.awt.Dimension(256, 256));
        imagen.setPreferredSize(new java.awt.Dimension(256, 256));
        imagen.setSize(new java.awt.Dimension(256, 256));

        imgAnterior.setText("anterior");
        imgAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgAnteriorActionPerformed(evt);
            }
        });

        imgSiguiente.setText("siguiente");
        imgSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgSiguienteActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText(producto.getNombre());
        nombre.setToolTipText("");

        precio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        precio.setText("$" + DF.format(producto.getPrecio()) + " x");

        descripcion.setText("<html><body style='width:150px'>"+producto.getDescripcion()+"</body></html>");

        cambia.setText((mainFrm.getPaso() == CliCarrito.CATALOGO) ? "añadir al carrito" : "actualizar carrito");
        cambia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imgSiguiente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cambia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imgAnterior)
                            .addComponent(imgSiguiente)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre)
                        .addGap(18, 18, 18)
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precio)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cambia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imgAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgAnteriorActionPerformed
        List<Icon> imagenes = producto.getImagenes();
        indiceImg = --indiceImg < 0 ? imagenes.size()-1 : indiceImg;
        imagen.setIcon(imagenes.get(indiceImg));
    }//GEN-LAST:event_imgAnteriorActionPerformed

    private void imgSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgSiguienteActionPerformed
        List<Icon> imagenes = producto.getImagenes();
        indiceImg = ++indiceImg > imagenes.size()-1 ? 0 : indiceImg;
        imagen.setIcon(imagenes.get(indiceImg));
    }//GEN-LAST:event_imgSiguienteActionPerformed

    private void cambiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiaActionPerformed
        mainFrm.cambiaOrden(producto.hashCode(), (int) cantidad.getValue());
    }//GEN-LAST:event_cambiaActionPerformed


    static final private java.text.DecimalFormat DF = new java.text.DecimalFormat("#.##");
    private int indiceImg;
    private Producto producto;
    private CliCarrito mainFrm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambia;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton imgAnterior;
    private javax.swing.JButton imgSiguiente;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel precio;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables

    private JLabel labelImg() {
        if(producto.getImagenes().isEmpty()) {
            indiceImg = -1;
            return new JLabel("no hay imágenes");
        } else {
            indiceImg = 0;
            return new JLabel(producto.getImagenes().get(0));
        }
    }
}
