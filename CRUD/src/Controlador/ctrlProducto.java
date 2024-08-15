
package Controlador;

import Modelo.Producto;
import Vista.frmProductos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;



public class ctrlProducto implements MouseListener{
    
    private frmProductos vista;
    private Producto modelo;
    
    public ctrlProducto(frmProductos Vista, Producto Modelo){
        this.vista = Vista;
        this.modelo = Modelo;
        vista.btnGuardar.addMouseListener(this);
        
        
        vista.jtbProductos.addMouseListener(this);
        modelo.Mostrar(vista.jtbProductos);
               
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == vista.btnGuardar){
       modelo.setNombre(vista.txtNombre.getText());
       modelo.setPrecio(Double.parseDouble( vista.txtPrecio.getText()));
       modelo.setCategoria(vista.txtCategoria.getText());
       modelo.Guardar();
       modelo.Mostrar(vista.jtbProductos);
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
