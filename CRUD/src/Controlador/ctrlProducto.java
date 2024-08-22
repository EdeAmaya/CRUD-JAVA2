
package Controlador;

import Modelo.Producto;
import Vista.frmProductos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;



public class ctrlProducto implements MouseListener,KeyListener{
    
    private frmProductos vista;
    private Producto modelo;
    
    public ctrlProducto(frmProductos Vista, Producto Modelo){
        this.vista = Vista;
        this.modelo = Modelo;
        vista.btnGuardar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);        
        vista.btnActualizar.addMouseListener(this);
        vista.jtbProductos.addMouseListener(this);
        vista.txtBuscar.addKeyListener(this);
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
       modelo.Limpiar(vista);
        }
       
       if (e.getSource() == vista.btnEliminar) {
                modelo.Eliminar(vista.jtbProductos);
                modelo.Mostrar(vista.jtbProductos);
            }
       
       if (e.getSource() == vista.jtbProductos){
       modelo.cargarDatosTabla(vista);
       }
        
       if (e.getSource() == vista.btnActualizar) {
            
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modelo.setNombre(vista.txtNombre.getText());
                    modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
                    modelo.setCategoria(vista.txtCategoria.getText());
                    

                    //Ejecutar el método    
                    modelo.Actualizar(vista.jtbProductos);
                    modelo.Mostrar(vista.jtbProductos);
                    modelo.Limpiar(vista);

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    if (e.getSource() == vista.txtBuscar) {
          modelo.Buscar(vista.jtbProductos, vista.txtBuscar);
        }
    }
   }
    

