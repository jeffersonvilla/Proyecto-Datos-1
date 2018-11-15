package detector;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.LinkedList;
import java.io.*;

/**
 * Codigo tomado y modificado de:
 * @url http://www.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html
 * @fecha Noviembre 2018
 * @modificado por Grupo proyecto datos 1
 */
// An AWT program inherits from the top-level container java.awt.Frame
public class GUI extends Frame implements ActionListener {
   private Label lbldir;    // Declare a Label component 
   private TextField tfdir; // Declare a TextField component 
   private Button btndir;   // Declare a Button component
   private Label lblname;
   private TextField tfname;
   private Label lblout;
   private TextField tfout;
   private Button btnname;
   
 
   // Constructor to setup GUI components and event handlers
   public GUI () {
      setLayout(new GridLayout(7,1,3,3));
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      lbldir = new Label("direccion del archivo con abejas");  // construct the Label component
      add(lbldir);                    // "super" Frame container adds Label component
 
      tfdir = new TextField("", 10); // construct the TextField component with initial text
      //tfCount.setEditable(false);       // set to read-only
      add(tfdir);                     // "super" Frame container adds TextField component
 
      lblname = new Label("nombre del archivo con abejas");
      add(lblname);
      
      tfname = new TextField("", 10);
      add(tfname);
      
      lblout = new Label("nombre del archivo de salida");
      add(lblout);
      
      tfout = new TextField("", 10);
      add(tfout);
      
      btndir = new Button("abrir");   // construct the Button component
      add(btndir);                    // "super" Frame container adds Button component

      btndir.addActionListener(this);
 
      setTitle("Predictor de colisiones");  // "super" Frame sets its title
      setSize(250, 250);        // "super" Frame sets its initial window size
 
      setVisible(true);         // "super" Frame shows
      
   }
   
   public static void main(String[] args) {
        
        //Inicia ventana
        GUI app = new GUI();
        
        //Cierra la ventana
        app.addWindowListener( new WindowAdapter() { 
            public void windowClosing( WindowEvent evt ) { 
            System.exit( 0 ); 
            } 
        } );
       
    }
    
    private static void predecirColisiones(String dir, String name, String out){ 
        QuadTree abejas = new QuadTree(); //Creo QuadTree  
        LinkedList<NodoT> colisiones = new LinkedList<>(); //Creo Lista enlazada                         
        IO.abriArchivo(abejas, dir, name); //Inserto elementos en QuadTree            
        QuadTree.colisiones(abejas,colisiones); //Busco colisiones proximas  
        IO.escribirArchivo(colisiones, dir, out);//Guardo colisiones en archivo
    
    }   
 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
       String dir = tfdir.getText();
       String name = tfname.getText();
       String out = tfout.getText();
       if(!dir.equals("")&&!dir.equals("Revisa los datos de entrada") 
               &&!dir.equals("Realizado correctamente") 
               && !name.equals("") && !out.equals("")){
           
        predecirColisiones(dir, name, out); //Predice colisiones
        tfdir.setText("Realizado correctamente");
        tfname.setText("");
        tfout.setText("");
       }else{
        tfdir.setText("Revisa los datos de entrada");
        tfname.setText("");
        tfout.setText("");
       };    
   }
}
