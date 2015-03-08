public class SortTester{
   public static void main(String[] args){
   
      GoodGuy ar = new Ariel() ;
      GoodGuy b = new Aladdin();
      GoodGuy c = new Belle();
      BadGuy d = new MinionBase();
      BadGuy e = new MinionBase();
      BadGuy f = new MinionBase();
      
      Character[] a = {ar, b, c, d, e, f};
      
      for(int i = 0; i < 6; i++){
         System.out.println(a[i].toString());
      }
      
      System.out.println();
      
      for (int i = 0; i < a.length-1; i++) {
         int index = i;
         for (int j = i + 1; j < a.length; j++){
            if(a[j].getSpeed() > a[index].getSpeed()){
               index = j;
            }
         }
         if(index != i){
            Character temp = a[i];
            a[i] = a[index];
            a[index] = temp;
         }
      }
      
      for(int i = 0; i < 6; i++){
         System.out.println(a[i].toString());
      }
   }
}
      