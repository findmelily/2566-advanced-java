

package collection;

import java.util.HashMap;
import java.util.Map;


public class Bag<E> {
    private Map<E,Integer> counter ;
    
    public Bag() {  counter = new HashMap(); }
    
    public int add(E e) { 
        if (e == null ) return -1; 
        Integer i = counter.get(e);
  
        if ( i == null ) i = 0;
        counter.put(e,++ i);
        return i; 
    }
          // i = sum kee tua
//        if (i == null) { // mai mee nai nun
//            counter.put(e, 1);
//            return 1;
//        }
    
//    public int remove(E e) {
//        if (e == null) { return -1;}
//        Integer i = counter.remove(e);
//       if (i == null) { return 0; }
//       
//       counter.remove(e , --i);
//        return --i; 
//    } //-1 when not found
//    
//    public int contains(E e) { return 0; }
//    public int get(E e) { return 0; }
    
        
    public int remove(E e) { 
        if (e == null ) return -1; 
        Integer i = counter.remove(e);
        counter.remove(e,-- i);
        return i; 
        
    }
    
}
