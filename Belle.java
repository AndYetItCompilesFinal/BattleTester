public class Belle extends GoodGuy
{

   public Belle()
   {
      name = "Belle";
      maxHP = 100;
      HP = 100;
      defense = .1;
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

   public int attack1(){
      System.out.println("Belle threw a book at the enemy!");
      return 5;
   }

   public int attack2(){
      System.out.println("Belle tried to kick the enemy!");
      return 10;
   }

   public int attack3(){
      System.out.println("Belle tried to hit the enemy!");
      return 5;
   }

}//end of class