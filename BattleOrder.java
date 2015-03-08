import java.util.Iterator;
import java.util.LinkedList;

public class BattleOrder implements Iterator{
   LinkedList turnOrder;
   int position;

   public BattleOrder(LinkedList list){
      this.turnOrder = list;
      this.position = -1;
   }

   public Object next(){
      position++;
      return turnOrder.get(position);
   }

   public boolean hasNext() {
      int size = turnOrder.size();
      if(size == 0){
         return false;
      } else if (position == size-1) {
         return false;
      }else{
         return true;
      }
   }

   public void remove() {
      if(position <= 0) {
         System.out.println("You must do a next first.");
      }
      if(turnOrder.get(position - 1)!= null){
         turnOrder.remove(position);
      }
   }
}