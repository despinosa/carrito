/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supernaut.redes2.carrito;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author supernaut
 */
public class ServCarrito extends ServerSocket {

    static final short PTO = 9090;
    Map<Integer, Producto> inventario;
    ArrayList<Socket> clientes;

    
    public ServCarrito() throws IOException {
        super(PTO);
        inventario = new HashMap<>();
        clientes = new ArrayList<>();
    }

    public ServCarrito(String dumpLoc) throws IOException {
        super(PTO);
        inventario = new HashMap<>();
        clientes = new ArrayList<>();
        try {
            init(new FileInputStream(dumpLoc));
        } catch(IOException ex) {
            Logger.getLogger(ServCarrito.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
    }

    private void init(FileInputStream dumpFile) throws IOException {
        Producto nuevo;
        ObjectInputStream objIn;
        System.out.println("inicializando inventario");
        objIn = new ObjectInputStream(dumpFile);
        inventario = new HashMap<>();
        try {
            while((nuevo = (Producto) objIn.readObject()) != null)
                inventario.put(nuevo.hashCode(), nuevo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServCarrito.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
    }

    private void dump(FileOutputStream dumpFile) throws IOException {
        Producto nuevo;
        ObjectOutputStream objOut;

        System.out.println("vaciando inventario");
        objOut = new ObjectOutputStream(dumpFile);
        for(Producto producto : inventario.values())
            objOut.writeObject(producto);
    }
    
    public void run() {
        Socket nuevo;
        ObjectOutputStream objOut;
        HashMap<Integer, Short> orden; // item -> cantidad
        ObjectInputStream objIn;
        boolean exito;
        float recibo = 0;
        Producto pedido;

        try {
            nuevo = accept();
            System.out.println("conectado con " + nuevo.getInetAddress());
            clientes.add(nuevo);
            /* enviar catalogo e imagenes */
            objOut = new ObjectOutputStream(nuevo.getOutputStream());
            objOut.writeObject(inventario);
            objOut.flush();
            /* esperar y procesar orden */
            objIn = new ObjectInputStream(nuevo.getInputStream());
            orden = (HashMap<Integer, Short>) objIn.readObject();
            exito = true;
            for(Integer key : orden.keySet()) {
                pedido = inventario.get(key);
                if(pedido.getDisponibilidad() < orden.get(key)) {
                    exito = false;
                    break;
                } else {
                    pedido.setDisponibilidad((short) (pedido.getDisponibilidad()
                                                      - orden.get(key)));
                    recibo += orden.get(key) * pedido.getPrecio();
                }
            }
            /* enviar recibo */
            objOut.writeBoolean(exito);
            objOut.writeFloat(recibo);
            objOut.flush();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServCarrito.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        short disponibilidad;
        float precio;
        Producto nuevo;
        ServCarrito servidor;
        String nombre, descripcion, continua, arr[];
        List<String> rutasImg;
        Scanner termIn;
        
        termIn = new Scanner(System.in);
        try {
            if(args.length < 1) {
                servidor = new ServCarrito();
                System.out.println("añade productos");
                do {
                    System.out.println("");
                    System.out.print("nombre: ");
                    nombre = termIn.nextLine();
                    System.out.print("descripción: ");
                    descripcion = termIn.nextLine();
                    System.out.print("precio: ");
                    precio = termIn.nextFloat();
                    System.out.print("disponibilidad: ");
                    disponibilidad = termIn.nextShort();
                    System.out.print("rutas de imágenes (separa por '%'): ");
                    termIn.nextLine(); arr = termIn.nextLine().split("%", 0);
                    rutasImg = new ArrayList<>(Arrays.asList(arr));
                    rutasImg.removeAll(Arrays.asList(""));
                    nuevo = new Producto(nombre, descripcion, precio,
                            disponibilidad, rutasImg);
                    servidor.inventario.put(nuevo.hashCode(), nuevo);
                    System.out.print("más productos? (y/n) ");
                    continua = termIn.nextLine();
                } while(!continua.equalsIgnoreCase("n"));
            } else {
                servidor = new ServCarrito(args[0]);
            }
            System.out.println("esperando clientes\n");
            do {
                servidor.run();
                System.out.println("atiendo más clientes? (y/n)");
                continua = termIn.nextLine();
            } while(!continua.equalsIgnoreCase("n"));
            servidor.dump(new FileOutputStream("inventario.dmp"));
        } catch (IOException ex) {
            Logger.getLogger(ServCarrito.class.getName()).log(Level.SEVERE,
                                                              null, ex);
        }
    }

}
