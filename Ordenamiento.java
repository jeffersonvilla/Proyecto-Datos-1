package project;
/**
 *
 * @author 
 */
public class Ordenamiento {
    
    /**
     * Ordena elementos de menor a mayor en O(n logn)
     */
    public static void quickSort(LL list){        
        quick(list, list.primero(), list.fin());
    }
    
    /*
    * QuickSort recursivo
    */
    public static void quick(LL list, NodoLL a, NodoLL b){
        NodoLL piv = a;
        
        //condicion de parada
        
        // No cambia el pivote a traves de las recursioness
        if(!(a.equals(b)&&!b.equals(a.next()))){
            piv = pivote(list, a, b);
            System.out.println("piv "+ piv.toString());
            System.out.println("1");
            quick(list, a, piv);
            System.out.println("2");
            quick(list, piv.next(), b);            
        }
    }
        
    /*
    * Elije el pivote con elementos menores al pivote a la izquierda
    */
    private static NodoLL pivote(LL list, NodoLL a, NodoLL b){
        NodoLL q = a;
        NodoLL p = a.last();
        while(!q.equals(b)){
            if(abs(q.x()) <= abs(b.x())){
                p = (p == null)? a: p.next();
               // list.cambio(p, q);
               // NodoLL aux = p;
               // p = q;
               // q = aux;
            }
            System.out.println("p "+p.toString());
            System.out.println("q "+q.toString());
            q = q.next();            
        }
        p = p.next();
        list.cambio(p, q);     
        list.toString();
        return q;        
    }
    
    private static double abs(double n){return n>0? n:-n;}
    
}