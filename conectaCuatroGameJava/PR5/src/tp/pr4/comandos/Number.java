package tp.pr4.comandos;


public abstract class Number 
{
			
		public static boolean isNumber(String line)
		{
			 
		        try 
		        {
		            Integer.parseInt(line);
		            return true;
		        } 
		        
		        catch (NumberFormatException nfe) {
		            return false;
		        }
		}
}

