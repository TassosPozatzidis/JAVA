package Lesson1;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.io.PrintStream;
import java.io.IOException;
    public class parser
    {
    	
    	static void CountWords(String filename, Map< String, Integer> words) throws FileNotFoundException
    	{
    	Scanner file=new Scanner (new File(filename));
    	while(file.hasNext()){
    	String word=file.next();
    	Integer count=words.get(word);
    	if(count!=null)
    	count++;
    	else
    	count=1;
    	words.put(word,count);
    	}
    	file.close();
    	}
    
        public static void main(String args[]) throws IOException{
        
        File file =new File("C:\\Users\\Tassos_PC\\Desktop\\xml\\dblp-2021-11-02.xml");
       
        Scanner in = null;
        Scanner inputFile = null;
        
        Scanner kbReader = new Scanner(System.in);

        int count=0;
        try {
            in = new Scanner(file);
            
            //System.out.print("Type a name for this file, followed by hitting 'enter': ");
            //String fName = kbReader.nextLine();
            File yourFile = new File("C:\\Users\\Tassos_PC\\Desktop\\xml\\sth.txt");
            File fileOut =yourFile;
            FileWriter fw = new FileWriter(yourFile, true);
            inputFile = new Scanner(fileOut);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("<year>")) {
                	
                    System.out.println((line.replace("<year>", "").replace("</year>","")));
                fw.write(((line.replace("<year>", "").replace("</year>",""))));
                fw.write("\r\n");
                count++; }
            }
          
            fw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       // Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        Map<String,Integer> words=new HashMap<String, Integer>();
        CountWords("C:\\Users\\Tassos_PC\\Desktop\\xml\\sth.txt",words);
        System.out.println(words);

        if(count!=0) 
        {
          System.out.println("The word is present "+ count + " times in the file");
        }
        else
        {
          System.out.println("The word doesn't exist in the file!");
        } 


        
    }}
