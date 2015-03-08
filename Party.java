public class Party
{
   GoodGuy[] party;
   
   public Party(GoodGuy a, GoodGuy b, GoodGuy c){
	party = new GoodGuy[3];
      party[0] = a;
      party[1] = b;
      party[2] = c;
   }
   
   public GoodGuy getParty(int index){
      return party[index];
   }
   
   public void setParty(GoodGuy chara, int index){
      party[index] = chara;
   }
   
   public String toString(){
     String str = ("Your party consists of " + party[0].toString()+ ", " + party[1].toString() + ", and " + party[2].toString() + ". ");
	  return str;
   }
	
	public GoodGuy getMain()
	{
		return /*(MainCharacter)*/party[0];
	}
   
   public boolean partyAlive(){
      if(!party[0].isAlive() && !party[1].isAlive() && !party[2].isAlive()){
         return false;
      }
      return true;
   }
}//end of class