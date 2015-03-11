import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

public class BattleSetup implements Iterable{
   LinkedList turnOrder;

   public BattleSetup(){
      turnOrder = new LinkedList();
   }

   //Adds a character to the order list and returns if it was successfully added
   public boolean addChar(Character c){
       return turnOrder.add(c);
   }

   public Iterator iterator() {
      return new BattleOrder(turnOrder);
   }
   
}
