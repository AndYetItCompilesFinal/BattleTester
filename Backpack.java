import java.util.*;

public class Backpack
{
	ArrayList list;
	
	public Backpack()
	{
		this.list= new ArrayList();
	}
   public String toString()
   {
      int count = 1;
      String result="Backpack:\n";
      for(Object o:list)
      {
         result+= count + ". " + o.toString();
         result+="\n";
         count++;
      }
      return result;
   }
	
}//end of class