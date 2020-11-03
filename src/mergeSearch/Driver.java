package mergeSearch;
import java.util.Random;

public class Driver
{
	public static void main(String[] args)
	{
		//Creating an arrayOfPlayers that contains 10 player objects, each with a name and random age
		Player[] arrayOfPlayers = new Player[8];
		Random r = new Random();
		
		for(int i = 0; i < arrayOfPlayers.length; i++)
		{
			int randomAge = r.nextInt(100);
			arrayOfPlayers[i] = new Player("Player " + (i+1), randomAge);
		}
		
		for(int i = 0; i < arrayOfPlayers.length; i++)
		{
			arrayOfPlayers[i].display();
		}

		Player.mergeSort(arrayOfPlayers, 0, arrayOfPlayers.length-1);
		System.out.println("--Sorted--");
		
		for(int i = 0; i < arrayOfPlayers.length; i++)
		{
			arrayOfPlayers[i].display();
		}
		
		boolean answer = Player.binarySearch(arrayOfPlayers, 19);
		System.out.println(answer);
		
	}
}
