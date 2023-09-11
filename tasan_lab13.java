import java.util.ArrayList;

class tasan_lab13
{
	private ArrayList<Integer> V = null;
	
	public void readData(String filename)
	{
		V = new ArrayList<>();
		try
		{
			String inn;
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			while( (inn = input.readLine()) != null )
			{
				V.add(Integer.valueOf(inn.trim()));
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public long getTotalCount()
	{
		return V.stream().count();
	}
	
	public long getOddCount()
	{
		return V.stream().filter(x -> x % 2 == 1).count();
	}
	
	public long getEvenCount()
	{
		return V.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return V.stream().distinct().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1()
	{
		return V.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return V.stream().map(x -> 3*x*x).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return V.stream().filter(x -> x % 2 == 1).map(x -> 2*x).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
