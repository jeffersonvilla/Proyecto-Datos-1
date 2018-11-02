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
    * QuickSort recursivo  O(n^2) con c = 1/3700000000
    * T(n)= c n^2, para n = 100'000.000 toma 45 min
    * para n = 10'000.000 toma 30 segundos
    * mejor que O(n)
    */
    public static void quick(LL list, NodoLL a, NodoLL b){
        NodoLL piv;        
        if(!a.equals(b)&&!a.equals(b.next())&&b!=null){
            piv = pivote(list, a, b);
            if(a!= null && piv.last()!= null)
                quick(list, a, piv.last());      
            if(piv!=null && b != null)
                quick(list, piv, b);            
        }else if(b.equals(a.next()))if((b.x())<(a.x()))list.cambio(a, b);
    }
        
    /*
    * Elije el pivote con elementos menores al pivote a la izquierda
    */
    private static NodoLL pivote(LL list, NodoLL a, NodoLL b){
        NodoLL q = a;
        NodoLL p = a.last();
        while(!q.equals(b)){
            if((q.x()) <= (b.x())){
                if(p == null) p = a;
                else p = p.next();
                list.cambiovalor(p, q);
            }            
            q = q.next();            
        }
        if(p == null) p = a;
        else p = p.next();
        list.cambiovalor(p, q);     
        return p;        
    }
    
}