import java.util.Scanner;

public abstract class GoodGuy extends Character
{
   String attack1;
   String attack2;
   String attack3;



   public String printStats()
   {
      return toString() +"\n"+ "HP: "+this.HP+"\nDefense: "+this.defense+"\nSpeed: "+this.speed+"\nAttack: "+this.attack;
   }

   public void addHP(int h){
      HP = HP + h;
      if(HP >= maxHP) {
         HP = maxHP;
         System.out.println(name + " was fully healed!");
      }else{
         System.out.println(name + " has healed " + h + "hit points. They are at " + HP + " out of " + maxHP + " hit points.");
      }
   }

   public int chooseAttack(){
      int att = 0;
      while(att < 1 || att > 3) {
         System.out.println("Choose your Attack!");
         System.out.println("1. " + attack1);
         System.out.println("2. " + attack2);
         System.out.println("3. " + attack3);
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter number now: ");
         att = sc.nextInt();
      }
      int base;
      if( att == 1){
         base = attack1();
      }else if( att == 2){
         base = attack2();
      }else{
         base = attack3();
      }
      return base;
   }

}//end of class