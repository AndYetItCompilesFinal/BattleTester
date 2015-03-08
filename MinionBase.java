/**
 * Created by Zoe on 3/5/2015.
 */
public class MinionBase extends BadGuy {
   public MinionBase(){
      name = "Minion";
      maxHP = 200;
      HP = 200;
      defense = .05;
      speed = 3;
      attack = 0;
      alive = true;
      good = false;
      greeting = "hello";
      goodBye = "bye";
   }

   public int attack1(){
      System.out.println("The Minion tried to kick you!");
      return 1;
   }

   public int attack2(){
      System.out.println("The Minion tried to punch you!");
      return 1;
   }

   public int attack3(){
      System.out.println("The Minion tried to headbutt you!");
      return 1;
   }
}
