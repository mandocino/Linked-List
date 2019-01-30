import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.FileInputStream;
import java.util.Collections;
/**
 * The driver class to test part 1.
 * @author Armando Mancino 40078466
**/
public class Driver {
	public static void main(String[] args) {
		String file;
		int Counter=0;
		int HappaxCounter=0;
		int StopCounter=0;
		DecimalFormat df = new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.UP);
		Scanner theKeyboard= new Scanner(System.in);
		ArrayList <String> wordList= new ArrayList<String>();
		ArrayList <Integer> numList= new ArrayList<Integer>();
		//System.out.print("Enter input file: ");
		//file=theKeyboard.next();
		try 
		{
			Scanner sc=new Scanner(new FileInputStream("jokes.txt"));
			String currentString;
			while (sc.hasNext()) 
			{
				currentString=sc.next();
				currentString=currentString.toLowerCase();
				if (!(currentString.contains(";")||currentString.contains("‘")||currentString.contains(".")||currentString.contains(",")|| currentString.contains("(")||currentString.contains(")")||currentString.contains(":")|| currentString.contains("-")|| currentString.contains("’")))
				{
					Counter++;
					if (!wordList.contains(currentString)) 
					{
						wordList.add(currentString);
						int index;
						index= wordList.indexOf(currentString);
						numList.add(index, 1);
					}
					else 
					{
						int index;
						index= wordList.indexOf(currentString);
						int tracker=numList.get(index);
						numList.remove(index);
						numList.add(index, tracker+1);
					}
				}
			}
			System.out.println("Done");
			for (int C=0; C<numList.size();C++) 
			{
				for (int R=0; R<numList.size()-C; R++) 
				{
					if (numList.get(C)>numList.get(R)) 
					{
						Collections.swap(numList, C, R);
						Collections.swap(wordList, C, R);
					}
				}
			}
			System.out.println("----------------------------------");
			System.out.println("Rank           Freq           Word");
			System.out.println("----------------------------------");

			for (int C=0; C<wordList.size(); C++) 
			{
				System.out.println (C+1+"              "+numList.get(C)+"              "+wordList.get(C));
				if (numList.get(C)==1)
					HappaxCounter++;
				if (wordList.get(C).length()<=4 && numList.get(C)>=10) 
					StopCounter++;		
			}
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("Nb of word tokens: "+Counter);
			System.out.println("Nb of word tokens: "+wordList.size());
			System.out.println();
			System.out.println("Nb of Happax: "+HappaxCounter);
			double Happaxpercent=(double)HappaxCounter/wordList.size()*100;
			System.out.println("% of Happax: "+df.format(Happaxpercent)+"%");
			Happaxpercent=(double)HappaxCounter/Counter*100;
			System.out.println("Happax account for: "+df.format(Happaxpercent)+"% of the text");
			System.out.println();
			System.out.println("Nb of stop words: "+StopCounter);
			double Stoppercent=(double)StopCounter/wordList.size()*100;
			System.out.println("% of stop words: "+df.format(Stoppercent)+"%");
			Stoppercent=(double)StopCounter/Counter*100;
			System.out.println("Stop words account for: "+df.format(Stoppercent)+"% of the text");
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("Error! File not found!");
		}
	}

}

