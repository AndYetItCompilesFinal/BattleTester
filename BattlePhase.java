import java.util.Iterator;
import java.util.Scanner;

public class BattlePhase {
   //Sets up turn order and sets attack into motion
   public static boolean battle(Party good, BadGuy[] bad) {
      BattleSetup order = new BattleSetup();
      //add characters to order based on speed stat
      Character[] a = {good.getParty(0), good.getParty(1), good.getParty(2), bad[0], bad[1], bad[2]};
      
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

      for (Character c : a) {
         order.addChar(c);
      }

      boolean win = round(order, good, bad);
      if(win){
         System.out.println("Your team won the fight!");
         return true;
      }else{
         System.out.println("Your team lost the fight!");
         return false;
      }
   }

   //Continues to go through turn order and runs turn operations
   public static boolean round(BattleSetup order, Party good, BadGuy[] bad) {
      boolean survivedTurn;
      while(good.partyAlive() && !victory(bad)){
         for (Object o : order) {
            Character c = (Character)o;
            if(c.isAlive()){
               System.out.println(c.toString() + "'s turn!");
               if (c.isGood()) {
                  int choice = displayMenu();
                  if (choice == 1) {
                     int baseAttack = ((GoodGuy)c).chooseAttack();
                     int dmg = damage(c.getStrength(), baseAttack);
                     int index = chooseTarget(c, bad);
                     if(bad[index].dodgeAttempt()){
                        System.out.println("The attack missed.");
                     }else{
                        System.out.println("The attack hit for " + dmg +".");
                        boolean alive = bad[index].applyDamage(dmg);
                        if (!alive){
                           if(victory(bad)){
                              return true;
                           }
                        }
                     }
                  } else {
                     //pull up the backpack to use the item
                     System.out.println("Access the backpack items here.");
                  }
               } else {
                  survivedTurn = villanTurn(c, good);
                  if(!survivedTurn){
                    if(!good.partyAlive()){
                       return false;
                    }
                  }
               }
            }
         }
      }
      return false;
   }

   //Calculates a random damage in a range
   public static int damage(int str, int base) {
      int dmg = base;
      for (int i = 1; i <= str; i++) {
         dmg = dmg + ((int) (Math.random() * (6 - 1) + 1));
      }
      dmg = dmg + base;
      return dmg;
   }

   //Lets user pick to attack or use an item
   public static int displayMenu() {
      Scanner kb = new Scanner(System.in);
      System.out.println("Do you want to: ");
      System.out.println("1. Attack");
      System.out.println("2. Item");
      System.out.println("Enter your choice: ");
      int choice = kb.nextInt();
      return choice;
   }

   //Automatically runs through the villan's turn, returning whether the hero survived the attack
   public static boolean villanTurn(Character c, Party good) {
      int baseAttack;
      int damage;
      baseAttack = c.chooseAttack();
      damage = damage(c.getStrength(), baseAttack);
      // choose hero to attack
      int choice = ((int)(Math.random() * ((3 - 1)+1)));
      boolean survived = true;
      do {
         if (good.getParty(choice).isAlive()) {
            if (good.getParty(choice).dodgeAttempt()) {
               System.out.println("The attack missed.");
            } else {
               System.out.println("The attack hit for " + damage + ".");
               survived = good.getParty(choice).applyDamage(damage);
            }
         }
      }while(!good.getParty(choice).isAlive());
      return survived;
   }

   //Lets the user choose the target to attack
   public static int chooseTarget(Character c, BadGuy[] bad){
      int target = 0;
      while(target < 1 || target > 3) {
         System.out.println("Who do you want to attack?");
         System.out.println("1. " + bad[0].toString());
         System.out.println("2. " + bad[1].toString());
         System.out.println("3. " + bad[2].toString());
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
   public static boolean victory(BadGuy[] bad){
      if(!bad[0].isAlive() && !bad[1].isAlive() && !bad[2].isAlive()){
         System.out.println("Minion 1: " + bad[0].getStrength());
         return true;
      }
      return false;
   }

}
