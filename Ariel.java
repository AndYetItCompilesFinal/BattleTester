public class Ariel extends GoodGuy
{

   public Ariel()
   {
      name = "Ariel";
      maxHP = 100;
      HP = 100;
      defense = .2;
      speed = 5;
      attack = 20;
      alive = true;
      good = true;
      greeting = "Hello!";
      goodBye = "Goodbye!";
      attack1 = "Attack One";
      attack2 = "Attack Two";
      attack3 = "Attack Three";
   }

   public int attack1(){
      System.out.println("Ariel tried to punch the enemy!");
      return 10;
   }

   public int attack2(){
      System.out.println("Ariel tried to hit the enemy!");
      return 15;
   }

   public int attack3(){
      System.out.println("Ariel tries to headbutt the enemy!");
      return 20;
   }

}//end of class