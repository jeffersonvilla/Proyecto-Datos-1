package project;

/**
 *
 * @author 
 */
public class NodoLL {
    private double x;
    private double y;
    private double z;
    
    private NodoLL next;
    private NodoLL last;
    
    public NodoLL(){
        this.x = this.y = this.z = 0;
        this.next = this.last = null;
    }
    
    public NodoLL(double x, double y, double z){
        this.x = x; this.y = y; this.z = z;
        this.next = null;
        this.last = null;
    }
    
    public NodoLL(NodoLL n){
        this.x = n.x();
        this.y = n.y();
        this.z = n.z();
    }
    
    //Cambia los valores del nodo
    public void punto(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    //Retorna el siguiente
    public NodoLL next(){return this.next;}
    
    //Inserta el siguiente
    public boolean next(NodoLL next){this.next = next; return true;}
    
    //Asigna siguiente nodo a null
    public boolean nextNull(){this.next = null; return true;}
    
    //Retorna el anterior
    public NodoLL last(){return this.last;}
    
    //Inserta el anterior
    public boolean last(NodoLL last){this.last = last; return true;}
    
    //Asigna anterior a null
    public boolean lastNull(){this.last = null; return true;}
    
    public double x(){return this.x;}
    
    public double y(){return this.y;}
    
    public double z(){return this.z;}
    
    public String toString(){ return "("+this.x+", "+this.y+", "+this.z+")";}
}
