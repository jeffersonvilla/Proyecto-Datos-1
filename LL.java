package project;

/**
 *
 * @author 
 */
public class LL {
    
    private NodoLL raiz = new NodoLL();
    private NodoLL cola = new NodoLL();
    
    private int size = 0;
    
    /*
    * Inserta nodo en la posicion p
    */
    public boolean insertar(NodoLL nodo, int p){
        //Comprueba nodo null
        if(nodo == null) return false;
        
        //Comprueba p en rango
        if(p > this.size || p < 0) return false;
        
        //Si la lista esta vacia
        if(this.size == 0){
            this.raiz.next(nodo);
            this.cola.last(nodo);
            this.size++;
            return true;
        }
        
        //Al inicio de la lista
        if(p == 0){
            try{
                nodo.next(this.raiz.next());
                this.raiz.next().last(nodo);
            }catch(NullPointerException e){}
            nodo.last(this.raiz);
            this.raiz.next(nodo);
            this.size++;
            return true;
        }
        
        //Al final de la lista
        if(p == this.size){
            this.cola.last().next(nodo);
            nodo.last(this.cola.last());
            this.cola.last(nodo);
            this.size++;
            return true;
        }
        
        //En otro lugar de la lista
        NodoLL n = this.raiz; //nunca nulo
        //recorrer hasta llegar al nodo en la posicion p
        for(int i = 0; i < p; i++){                  
            NodoLL aux = n; 
            try{
                aux = n.next(); //puede ser nulo                
            }catch(NullPointerException e){}
            n = aux;
        }
        nodo.next(n.next()); //Asigna siguinete al nodo
        n.next().last(nodo); //Doble enlace con el siguiente nodo
        n.next(nodo); //Enlaza con el anterior
        nodo.last(n);
        this.size++;
        return true;
    }
    
    /*
    * Elimina nodo en la posicion p
    */
    public boolean eliminar(int p){
        //Lista vacia
        if(this.size == 0) return false;
        
        //Comprueba p en rango
        if(p >= this.size || p < 0) return false;
        
        //Solo un elemento en la lista
        if(this.size == 1){
            this.raiz.nextNull();
            this.cola.lastNull();
            this.size--;
            return true;
        }
        
        //Nodo al incio
        if(p == 0){
            try{
                this.raiz.next(this.raiz.next().next());
            }catch(NullPointerException e){this.raiz.nextNull();}
            this.raiz.next().lastNull();            
            this.size--;
            return true;
        }
        
        //Nodo al final
        if(p == this.size-1){
            this.cola.last(this.cola.last().last());
            this.cola.last().nextNull();
            this.size--;
            return true;
        }
        
        //Nodo en medio
        NodoLL n = this.raiz; //nunca nulo
        //recorrer hasta llegar al nodo en la posicion p
        for(int i = 0; i <= p; i++){                  
            NodoLL aux = n; 
            try{
                aux = n.next(); //puede ser nulo                
            }catch(NullPointerException e){}
            n = aux;
        } //al final del ciclo n esta en posicion p
        n.last().next(n.next());
        n.next().last(n.last());
        this.size--;
        return true;
    }
    
    /*
    * Retorna el nodo con valores (x, y, z)
    */
    public NodoLL localizar(double x, double y, double z){
        //Lista vacia
        if(this.size == 0) return null;
        
        NodoLL n = this.raiz; //nunca nulo
        //recorrer hasta llegar al nodo con los valores de entrada
        for(int i = 0; i < this.size; i++){                  
            NodoLL aux = n;
            if(aux.x() == x && aux.y() == y && aux.z() == z) return aux;
            try{
                aux = n.next(); //puede ser nulo                
            }catch(NullPointerException e){}
            n = aux;
        } //al final del ciclo n esta en posicion p
        return null;
    }
    
    /*
    * Retorna el nodo en la posicion p
    */
    public NodoLL recuperar(int p){
        //Lista vacia
        if(this.size == 0) return null;
        
        //Comprueba p en rango
        if(p >= this.size || p < 0) return null;
        NodoLL n = this.raiz; //nunca nulo
        //recorrer hasta llegar al nodo con los valores de entrada
        for(int i = 0; i <= p; i++){                  
            NodoLL aux = n;            
            try{
                aux = n.next(); //puede ser nulo                
            }catch(NullPointerException e){}
            n = aux;
        } //al final del ciclo n esta en posicion p
        return n;
    }
    
    /*
    * Retorna la posicion del nodo en la lista
    */
    public int posicion(NodoLL nodo){
      int p = 0;
      for(NodoLL i = this.raiz.next(); !i.equals(this.cola.last());i= i.next()){
          if(i.equals(nodo)) return p;
          p++;
        }
      return (nodo.equals(this.cola.last()))? p:-1;  
    }
    
    /*
    * Retorna elemento siguiente
    */
    public NodoLL proximo(NodoLL nodo){
        try{return nodo.next();}catch(NullPointerException e){return null;}
    }
    
    /*
    * Retorna elemento anterior
    */
    public NodoLL previo(NodoLL nodo){
        try{return nodo.last();}catch(NullPointerException e){return null;}
    }
    
    /*
    * Retorna primer elemento de la lista
    */
    public NodoLL primero(){
        try{return this.raiz.next();}catch(NullPointerException e){return null;}
    }
    
    /*
    * Retorna ultimo elemento de la lista
    */
    public NodoLL fin(){
       try{return this.cola.last();}catch(NullPointerException e){return null;}
    }
 
    /*
    * Retorna tamanio de la lista
    */
    public int size(){return this.size;}
    
    /*
    * Muestra lista en orden
    */
    public void showList(){
        if(this.size != 0){
            System.out.println("En orden");
            System.out.println("size: "+this.size);
            NodoLL p = this.raiz.next();
            System.out.println("info(p, "+0+"):"+p.toString());
            for(int i = 0; i<this.size-1; i++){
                p = p.next();
                System.out.println("info(p, "+(i+1)+"): "+p.toString());
            }        
        }else{System.out.println("No hay elementos en la lista");}
    }
    
    /*
    * Muestra lista en orden reverso
    */
    public void showListR(){
        System.out.println("Al revez");
        System.out.println("size: "+this.size);
        NodoLL l = this.cola.last();
        System.out.println("info(p, "+(this.size-1)+"):"+l.toString());
        for(int i = 0; i<this.size()-1; i++){
            l = l.last();
            System.out.println("info(p, "+(this.size-i-2)+"):"+l.toString());
        }
    }
    
    /*
    * Intercambia de posicion en la lista los nodos a y b
    */
    public void cambio(NodoLL p, NodoLL q){cambio(p, q, false);}
    
    /*
    * Intercambia de posicion en la lista los nodos a y b
    */
    private void cambio(NodoLL p, NodoLL q, boolean changed){
        //p es el primero, p y q discontinuos
        if(p.equals(this.raiz.next()) && !q.equals(this.cola.last()) 
                && !q.equals(p.next())){
            NodoLL aux = p.next();
            p.next(q.next());
            q.next(aux);
            aux.last(q);
            p.next().last(p);
            aux=q.last();
            p.last(aux);
            q.last(this.raiz);
            this.raiz.next(q);
            aux.next(p);
        }
        
        //p es el primero, p y q continuos
        else if(p.equals(this.raiz.next()) && !q.equals(this.cola.last())
                && q.equals(p.next())){
            p.next(q.next());
            q.next(p);
            p.next().last(p);
            q.lastNull();
            raiz.next(q);
        }
        
        //q es el ultimo, p y q discontinuos
        else if(q.equals(this.cola.last()) && !p.equals(this.raiz.next())
                && !q.equals(p.next())){
            q.last().next(p);
            p.next().last(q);
            q.next(p.next());
            p.nextNull();
            NodoLL aux = q.last();
            q.last(p.last());
            p.last().next(q);
            p.last(aux);
            this.cola.last(p);
        }
        
        //q es el ultimo, p y q continuos
        else if(q.equals(this.cola.last()) && !p.equals(this.raiz.next())
                && q.equals(p.next())){
            p.last().next(q);
            q.last(p.last());
            p.last(q);
            q.next(p);
            p.nextNull();
            this.cola.last(p);
        }
        
        //p es el primero y q el ultimo, p y q discontinuos
        else if(q.equals(this.cola.last()) && p.equals(this.raiz.next())
                && !q.equals(p.next())){
            p.next().last(q);
            q.last().next(p);
            p.last(q.last());
            q.lastNull();
            q.next(p.next());
            p.nextNull();
            this.cola.last(p);
            this.raiz.next(q);
        }
        
        //p es el primero y q el ultimo, p y q continuos
        else if(q.equals(this.cola.last()) && p.equals(this.raiz.next())
                && q.equals(p.next())){
            p.nextNull();
            q.lastNull();
            this.raiz.next(q);
            this.cola.last(p);
            q.next(p);
            p.last(q);
        }
        
        else if(!changed) cambio(q, p, true);
    }
    
}
