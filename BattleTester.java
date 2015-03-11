
public class BattleTester {
   public static void main(String[] args){
      GoodGuy a = new Ariel() ;
      GoodGuy b = new Aladdin();
      GoodGuy c = new Belle();
      Party p = new Party(a, b, c);

      BadGuy[] bad = new BadGuy[3];
      bad[0] = new MinionBase();
      bad[1] = new MinionBase();
      bad[2] = new MinionBase();
      
      Backpack bp = new Backpack();
      HealthPotionHP10 h1 = new HealthPotionHP10();
      HealthPotionHP10 h2 = new HealthPotionHP10();
      HealthPotionHP10 h3 = new HealthPotionHP10();
      bp.list.add(h1);
      bp.list.add(h2);
      bp.list.add(h3);
      
      BattlePhase battle = new BattlePhase();
      boolean victory = battle.battle(p, bad, bp);
      if(victory){
         System.out.println("You are free to continued on.");
      }else{
         System.out.println("You lost, and can quit or retry");
      }
   }
}

