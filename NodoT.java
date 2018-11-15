package detector;

/**
 *
 * @author Grupo proyecto datos 1
 */
public class NodoT {                    
    
    private double x;
    private double y;
    private double z;
    
    
    //Crea nodo vacio
    public NodoT(){
        this.x = this.y = this.z = 0;
    }
    
    //Crea nodo con los valores
    public NodoT(double x, double y, double z){
        this.x = x; this.y = y; this.z = z;
    }
    
    //Clona el nodo
    public NodoT(NodoT n){
        this.x = n.x(); this.y = n.y(); this.z = n.z();
    }
    
    //Asigna los valores al nodo
    public void punto(double x, double y, double z){
        this.x = x; this.y = y; this.z = z;
    }
    
    //Retorna los valores del punto en el nodo
    public double x(){return this.x;}
    
    public double y(){return this.y;}
    
    public double z(){return this.z;}
        
    //Retorna los valores del punto en el nodo en String
    public String toString(){return "("+this.x+", "+this.y+", "+this.z+")";}
    
}
