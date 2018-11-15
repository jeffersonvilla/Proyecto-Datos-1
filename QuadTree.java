package detector;

import java.util.LinkedList;

/**
 *
 * @author Grupo proyecto datos 1
 */
public class QuadTree {
    
    //Contiene todos los cuadrantes
    private NodoT punto = null; 
    
    private QuadTree NE;
    private QuadTree NW;
    private QuadTree SE;
    private QuadTree SW;
    
    // Blanco: 0(vacio) 
    // Gris: 1(tiene subdivisiones) 
    // Negro: 2(contiene un punto)
    private int color = 0;
    
    public QuadTree(){}
    
    public QuadTree(double x, double y, double z){
        this.punto = new NodoT(x, y, z);
        this.color = 2;
    }
    
    public void insertar(NodoT n){insertar(n.x(), n.y(), n.z());}
    
    public void insertar(double x, double y, double z){        
        //Quadtree dividido
        if(this.color == 1){
            insert(x, y , z);
        }
        //QuadTree vacio
        if(this.punto == null){
            this.punto = new NodoT(x, y ,z);
            this.color = 2;
        }
        //QuadTree con un solo elemento
        else if(this.color == 2){
            dividir();
            this.color = 1;
            insert(x, y, z);
        }                                
    }
    
    /*
     * Detecta abejas a menos de 100m( En quadtree) y las guarda en la lista
     */
    public static void colisiones(QuadTree q, LinkedList<NodoT> n){
        boolean added = false;
        if(q.color() != 0){//Si el tree no esta vacio
            if(q.color() != 2){ //Si el tree tiene hijos
                try{if(Calc.distancia(q.punto(),q.NE().punto())<= 100){
                   // n.addFirst(q.NE().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{if(Calc.distancia(q.punto(),q.NW().punto())<= 100){
                   // n.addFirst(q.NW().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{if(Calc.distancia(q.punto(),q.SE().punto())<= 100){
                   // n.addFirst(q.SE().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{if(Calc.distancia(q.punto(),q.SW().punto())<= 100){
                   // n.addFirst(q.SW().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{colisiones(q.NE(), n);}catch(NullPointerException e){}
                try{colisiones(q.NW(), n);}catch(NullPointerException e){}
                try{colisiones(q.SE(), n);}catch(NullPointerException e){}
                try{colisiones(q.SW(), n);}catch(NullPointerException e){}
            }else return;
        }else return;
    }
    
    private void insert(double x, double y, double z){
        switch(cuadrante(x, y, z)){
                case 0: //Agrego a la lista
                    break;
                case 1: NE.insertar(x, y, z);
                    break;
                case 2: NW.insertar(x, y ,z);
                    break;
                case 3: SW.insertar(x, y, z);
                    break;
                case 4: SE.insertar(x, y, z);
            }
    }
    
    //NE=1, NW=2, SW=3, SE=4, como en plano cartesiano
    //Este cuadrante = 0
    private int cuadrante(double x, double y, double z){
        if(x > punto.x() && y > punto.y()) return 1;
        if(x > punto.x() && y < punto.y()) return 4;
        if(x < punto.x() && y > punto.y()) return 2;
        if(x < punto.x() && y < punto.y()) return 3;
        if(x == punto.x() && y > punto.y()) return 1;
        if(x == punto.x() && y < punto.y()) return 3;
        if(y == punto.y() && x > punto.x()) return 2;
        if(y == punto.y() && x < punto.x()) return 4;
        return 0;
    }
    
    //Divide el cuadtre en cuatro cuadtrees
    private void dividir(){
        NE = new QuadTree();
        NW = new QuadTree();
        SE = new QuadTree();
        SW = new QuadTree();
    }
    
    public int color(){return this.color;}
    
    public NodoT punto(){return this.punto;}
    
    public QuadTree NE(){return this.NE;}
    
    public QuadTree NW(){return this.NW;}
    
    public QuadTree SE(){return this.SE;}
    
    public QuadTree SW(){return this.SW;}
    
    public void preorden(){
        if(this.punto != null){
            System.out.println("Centro");
            System.out.println(this.punto.toString());
            if(this.color == 1){
                System.out.println("NE");
                NE.preorden(); 
                System.out.println("NW");
                NW.preorden(); 
                System.out.println("SW");
                SW.preorden(); 
                System.out.println("SE");
                SE.preorden();
            }
        }
    }
    
    public int posorden(){
        if(this.punto != null){
            //System.out.println("Centro");
            //System.out.println(this.punto.toString());
            if(this.color == 1){
                return 
                //System.out.println("NE");
                NE.posorden()+
                //System.out.println("NW");
                NW.posorden()+ 
                //System.out.println("SW");
                SW.posorden()+ 
                //System.out.println("SE");
                SE.posorden() + 1;
            }else return 1;
        }else return 0;
    }
     
    public int nivel(){
        if(this.punto != null){
            //System.out.println("Centro");
            //System.out.println(this.punto.toString());
            if(this.color == 1){
                return 
                //System.out.println("NE");
                Math.max(Math.max(NE.nivel(),
                //System.out.println("NW");
                NW.nivel()),Math.max(
                //System.out.println("SW");
                SW.nivel(), 
                //System.out.println("SE");
                SE.nivel())) + 1;
            }else return 1;
        }else return 1;
    } 
}
