package project;

/**
 *
 * @author 
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //En quadtree
        //Inserto elementos en quadtree        
        //Busco prediccion de colisiones
        
        //Creo LinkedList
        LL abejas = new LL();              
        
        //Inserto elementos
        insertar(abejas, args[0]);
        
        //Ordeno respecto a x
        long startTime = System.nanoTime();   
        Ordenamiento.quickSort(abejas);
        long endTime = System.nanoTime();
        abejas.showList();
        System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
        
        //Comparo en rango         
    }
    
    private static void insertar(LL list, String archivo){
        
    }
    
}
