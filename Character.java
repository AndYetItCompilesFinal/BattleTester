public abstract class Character
{
   protected String name;
   protected int maxHP;
   protected int HP;
   protected double defense;
   protected int speed;
   protected int attack;
   protected boolean alive;
   protected boolean good;
   protected String greeting;
   protected String goodBye;

   public abstract int attack1();

   public abstract int attack2();

   public abstract int attack3();

   public abstract int chooseAttack();

   public boolean isGood(){
      return good;
   }

   public boolean isAlive(){
      if(HP<=0){
         alive = false;
      }
      return alive;
   }

   public String sayGreeting(){
      return greeting;
   }

   public String sayGoodBye(){
      return goodBye;
   }

   public String toString(){
      return name;
   }

   public int getStrength(){
      return attack;
   }
   
   public int getHP(){
      return HP;
   }
   
   public int getSpeed(){
      return speed;
   }

   //calculates dodge, true if dodge successful, false if dodge failed
   public boolean dodgeAttempt(){
      double ran = Math.random();
      if(ran <= this.defense){
         return true;
      }else{
         return false;
      }
   }

   //subtracts damage from hp, false if character is not alive after damage, true if they survived the hit
   public boolean applyDamage(int d){
      this.HP = this.HP - d;
      if(this.HP <= 0) {
         this.HP = 0;
         if (this.good == true) {
            System.out.println(name + " has fallen!");
            return false;
         } else {
            System.out.println(name + " has been defeated!");
            return false;
         }
      }
      return true;
   }


}//end of class