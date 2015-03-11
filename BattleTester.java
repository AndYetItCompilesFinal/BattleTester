
public class BattleTester {
   public static void main(String[] args){
      GoodGuy a = new Ariel() ;
      GoodGuy b = new Aladdin();
      GoodGuy c = new Belle();
      Party p = new Party(a, b, c);

      BadGuy[] bad = new BadGuy[1];
      bad[0] = new MinionBase();
      BattlePhase battle=new BattlePhase();
      boolean victory = battle.battle(p, bad);
      if(victory){
         System.out.println("You are free to continued on.");
      }else{
         System.out.println("You lost, and can quit or retry");
      }
   }
}

