package project;

/**
 *
 * @author 
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
        return 0;
    }
    
    //Divide el cuadtre en cuatro cuadtrees
    private void dividir(){
        NE = new QuadTree();
        NW = new QuadTree();
        SE = new QuadTree();
        SW = new QuadTree();
    }
    
    
    public void colisiones(String archivo){
        //Busca colisiones proximas 
        //Escribe colisiones en archivo
        
        //Centro con los cuadrantes
        
    }
}
