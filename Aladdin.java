public class Aladdin extends GoodGuy
{

   public Aladdin()
   {
      name = "Aladdin";
      maxHP = 100;
      HP = 100;
      defense = .5;
      speed = 5;
      attack = 20;
      alive = true;
      good = true;
      greeting = "Hello";
      goodBye = "Bye";
      attack1 = "Attack one";
      attack2 = "Attack two";
      attack3 = "Attack three";
   }

   public int attack1() {
      System.out.println("Aladdin tried to slash the enemy with hsi sword. ");
      return 15;
   }

   public int attack2(){
      System.out.println("Aladdin tried to trip the enemy. ");
      return 5;
   }

   public int attack3() {
      System.out.println("Abu tried to jump on and attack the enemy.");
      return 5;
   }

}//end of class