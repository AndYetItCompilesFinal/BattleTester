import java.util.Iterator;
import java.util.Scanner;

public class BattlePhase {
   //Sets up turn order and sets attack into motion
   public Character[] a;
   public BadGuy[] bad;
   BattleSetup order;
   public Backpack back;

   
   public boolean battle(Party good, BadGuy[] b, Backpack bp) 
   {
      back = bp;
      order = new BattleSetup();
      this.bad= new BadGuy[b.length];
      for(int i = 0; i < b.length; i++){
         bad[i] = b[i];
      }
      //add characters to order based on speed stat
      this.a =new Character[3+bad.length];
      a[0] = good.getParty(0);
      a[1] = good.getParty(1);
      a[2] = good.getParty(2);
      int index = 3;
      for(int i = 0; i < bad.length; i++){
         a[index] = bad[i];
         index++;
      }
 
      //selection sort
      sort();
      for (Character c : a) 
      {
         order.addChar(c);
      }
      
      boolean win = round(order, good, bad);
      if(win)
      {
         System.out.println("Your party won the fight!");
         return true;
      }
      else{
         System.out.println("Your party lost the fight!");
         return false;
      }
   }//end of constructor
   
   
   public boolean battle(Party good, BadGuy bad, Backpack bp)
   {
     return battle(good, new BadGuy[]{bad}, bp);  
   }
   
   
   public void sort()
   {
      for (int i = 0; i < a.length-1; i++) 
      {
         int index = i;
         for (int j = i + 1; j < a.length; j++)
         {
            if(a[j].getSpeed() > a[index].getSpeed())
            {
               index = j;
            }
         }
         if(index != i)
         {
            Character temp = a[i];
            a[i] = a[index];
            a[index] = temp;
         }
      }
      //end of sort
   }

   //Continues to go through turn order and runs turn operations
   public boolean round(BattleSetup order, Party good, BadGuy[] bad) 
   {
      while(good.partyAlive() && !victory(bad))
      {
         for (Object o : order) 
         {
            Character c = (Character)o;
            if(c.isAlive())
            {
               System.out.println(c.toString() + "'s turn!");
               //if good guy
               if (c instanceof GoodGuy) 
               {
                  if(displayMenu((GoodGuy)c))
                  {
                     return true;
                  }
               } 
               //if badguy
               else {
                  if(!villanTurn(c, good)){
                     if(!good.partyAlive()){
                        return false;
                     }
                  }
               }
            }
         }
      }
      return true;
   }

   //Calculates a random damage in a range
   public int damage(int str, int base) {
      int dmg = base;
      for (int i = 1; i <= str; i++) {
         dmg+=((int) ((Math.random() * 5) + 1));
      }
      dmg+=base;
      return dmg;
   }

   //Lets user pick to attack or use an item
   public boolean displayMenu(GoodGuy c) 
   {
      int choice;
      Scanner kb = new Scanner(System.in);
      do{
         System.out.println("Do you want to: ");
         System.out.println("1. Attack");
         System.out.println("2. Item");
         System.out.println("Enter your choice: ");
         choice = kb.nextInt();
         if(choice<1||choice>2)
         {
            System.out.println("Invalid menu choice");
         }
      
      }while(choice<1||choice>2);
      if (choice == 1) 
      {
         int baseAttack = ((GoodGuy)c).chooseAttack();
         int dmg = damage(c.getStrength(), baseAttack);
         int index = chooseTarget(c, bad);
         if(bad[index].dodgeAttempt())
         {
            System.out.println("The attack missed.");
         }
         else
         {
            System.out.println("The attack hit for " + dmg +".");
            boolean alive = bad[index].applyDamage(dmg);
            if (!alive)
            {
               remove(index);
               if(victory(bad))
               {
                  return true;
               }
            }
         }
      }
      else 
      {
         int count = 1;
         System.out.println("The items that are in your backpack: ");
         System.out.println(back.toString());
      }
      return false;
   }

   //Automatically runs through the villan's turn, returning whether the hero survived the attack
   public boolean villanTurn(Character c, Party good) {
      int baseAttack;
      int damage;
      baseAttack = c.chooseAttack();
      damage = damage(c.getStrength(), baseAttack);
      // choose hero to attack
      int choice = ((int)(Math.random() * 3));
      boolean survived = true;
      do {
         if (good.getParty(choice).isAlive()) {
            if (good.getParty(choice).dodgeAttempt()) {
               System.out.println("The attack missed.");
            } 
            else {
               System.out.println("The attack hit for " + damage + ".");
               survived = good.getParty(choice).applyDamage(damage);
            }
         }
      }while(!good.getParty(choice).isAlive());
      return survived;
   }

   //Lets the user choose the target to attack
   public int chooseTarget(Character c, BadGuy[] bad){
      int target = 0;
      while(target < 1 || target > bad.length) {
         System.out.println("Who do you want to attack?");
         for(int i = 0; i < bad.length; i++)
         {
            System.out.println(i+1 +". " + bad[i].toString());;
         }
         System.out.println("Enter the number here: ");
         Scanner sc = new Scanner(System.in);
         target = sc.nextInt();
         if(target < 1 || target > 3){
            System.out.println("Invalid number.");
         }
         if(!bad[target-1].isAlive()){
            System.out.println("That enemy is no longer alive. Choose a different target.");
            target = -1;
         }
      }
      return target-1;
   }

   //returns whether the good guys won or not
   public boolean victory(BadGuy[] bad)
   {
      for(int i = 0; i<bad.length; i++){
         if(bad[i].isAlive())
         {
            return false;
         }
      }
      return true;
   }
   
   public void remove(int index){
      if(bad.length != 1){
         BadGuy[] temp = new BadGuy[bad.length-1];
         for(int i = 0; i<index; i++){
            temp[i] = bad[i];
         }
         for(int i = index+1; i<bad.length; i++){
            temp[i-1] = bad[i];
         }
         bad = temp;           
      } 
   }

}
