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

class Node{
	String key;
	String value;
	public Node(String key, String value){
		this.key = key;
		this.value = value;
	}
}
public class StringSubstitution {

//	static PrintWriter writer = null;
	public static void main(String args[])
	{
		
	    File file = new File(args[0]);
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			writer = new PrintWriter("the-file-name.txt", "UTF-8");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    try {
	    	 String line;
			while ((line = in.readLine()) != null) {
//				System.out.println(line);
			    String[] lineArray =  line.split(";");
			    if (lineArray.length > 0) {
			        //Process line of input Here
			    	Driver(lineArray[0].toString(),lineArray[1].toString());
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		writer.close();
 
	}
	public static void Driver(String s , String Pattern){
		StringBuilder S = new StringBuilder(s);
		StringBuilder MaskString = new StringBuilder(S);
//		String Pattern = new String("0110,1001,1001,0,10,11");
//		StringBuilder S = new StringBuilder("0011101010100101110010011010000001101010111111011011110111100001011111100");
//		StringBuilder MaskString = new StringBuilder(S);
//		String Pattern = new String("00,101101,00,01,00100,110011,110000,011001,011100,100000");
		
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
			while(MaskString.indexOf(temp.key ) != -1)
			{
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

//					System.out.println(MaskString);			
//					System.out.println(S);
			}
		}
		System.out.println(S);
	}


	}

