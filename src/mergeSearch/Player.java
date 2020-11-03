package mergeSearch;

public class Player
{
	private String name;
	private int age;
	
	public Player(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	static boolean binarySearch(Player[] ar, int ageSearchedFor)
	{
		int begin = 0;
		int end = ar.length-1;
		int middle;
		
		while(end <= begin)
		{
			middle = ((end + begin) / 2);
			if(ar[middle].age == ageSearchedFor)
			{
				return true;
			}
			else if(ageSearchedFor < ar[middle].age)
			{
				end = middle - 1;
			}
			else
			{
				begin = middle + 1;
			}
		}
		return false;
	}
	
	static void mergeSort(Player[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + ((end - begin)/2);
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSort(ar, begin1, end1);
			mergeSort(ar, begin2, end2);
			merge(ar, begin1, end1, begin2, end2);
		}
	}
	
	static void merge(Player[] ar, int begin1, int end1, int begin2, int end2)
	{
		Player[] temp = new Player[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(ar[pos1].age < ar[pos2].age)
				{
					temp[i] = ar[pos1];
					pos1++;
				}
				else
				{
					temp[i] = ar[pos2];
					pos2++;
				}
			}
			else
			{
				//either pos1 or pos2 is off the end of their list and the other guy is the 
				//default winner
				if(pos1 > end1)
				{
					temp[i] = ar[pos2];
					pos2++;
				}
				else
				{
					temp[i] = ar[pos1];
					pos1++;
				}
			}
		} //end of for loop
		
		//copy temp back over ar from begin1 to end2
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++)
		{
			ar[i] = temp[posInTemp];
			posInTemp++;
		}
	}
	
	public void display()
	{
		System.out.println("Name: " + this.name + ", Age: " + this.age);
	}
}
