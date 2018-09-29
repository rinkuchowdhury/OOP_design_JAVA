package spring_annotation_cls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import spring_annotation_int.FortuneService;

@Component
@Lazy
public class FileFortuneService implements FortuneService {
	
	private String fileName = "/Users/Avinash/Desktop/Spring/fortune-data.txt";
	private List<String> theFortunes;
	
	//generate random number
	private Random random=new Random();
	
	public FileFortuneService() {
		File theFile = new File (fileName);
		System.out.println("Reading fortune file " + theFile);
		System.out.println("file exists: "+ theFile.exists());
		
		//initialize array list
		theFortunes=new ArrayList<String>();
		
		
		//read fortunes from file into array
		try(BufferedReader br =new BufferedReader(new FileReader(theFile))){
			String tempLine;
			
			while((tempLine=br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		// pick random string from the array
		int index=random.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);
		
		return "fileFortuneService: inside getFortune: " + tempFortune;

	}
}