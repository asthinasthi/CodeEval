import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

class Node1{
	String key;
	String value;
	public Node(String key, String value){
		this.key = key;
		this.value = value;
	}
}
 
public class Test {

	public static void main(String args[])
	{
    	Driver();
	}
	public static void Driver(){
		StringBuilder S = new StringBuilder("1111010100010100101001110011000001011000101001011100000011100001010");
		StringBuilder MaskString = new StringBuilder(S);
		String Pattern = new String("001101,10,11,00,10,101110");
		
		LinkedHashMap<String,String> FN = new LinkedHashMap<String,String>();
		String[] fns =  Pattern.split(",");
		
		for(int i = 0 ; i < fns.length ; i=i+2)
		{
			int keyIndex = i;
			int valueIndex = i+1;
			FN.put(fns[keyIndex], fns[valueIndex]);
		}
		
		LinkedList FNList = new LinkedList();

		for(int i = 0 ; i < fns.length ; i=i+2)
		{
			int keyIndex = i;
			int valueIndex = i+1;
			Node temp = new Node(fns[keyIndex], fns[valueIndex]);
			FNList.add(temp);
		}
		
		Iterator index = FNList.iterator();
		for(int i = 0 ; i < FNList.size() ;i++)
		{
			Node temp = (Node) FNList.get(i);
			while( (MaskString.indexOf(temp.key ) != -1) )
			{
				System.out.println(S);
				int start = MaskString.indexOf(temp.key);
				int end = start + temp.key.length();

					
					String replacement = new String( temp.value);
//					System.out.println("String before " + S);
					
					S = S.replace(start,end, replacement);
//					System.out.println(S);
					int endMaskIndex = start + replacement.length();
					StringBuilder repMask = new StringBuilder();
					for(int j = start ;j <endMaskIndex ; j ++)
					{
						repMask = repMask.append('x');
					}
					
					MaskString.replace(start, end, repMask.toString());

					System.out.println(MaskString);			
//					System.out.println(S);
			}
		}
		System.out.println(S);
	}

	}

