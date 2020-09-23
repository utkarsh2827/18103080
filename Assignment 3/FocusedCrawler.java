import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;
public class FocusedCrawler{
	public static void print(String msg){
		System.out.print(msg);
	}
   public static void main(String[] args){
		try{
			String BASE_URL = "http://pec.ac.in";
			// Retrieving all the department urls
			Document document = Jsoup.connect(BASE_URL+"/departments").get();
			Elements tags = document.body().select("div.field-item a");
				
				Set<String> department_faculties = new HashSet<String>();
			for (Element tag : tags) {
				department_faculties.add(BASE_URL+"/faculty"+tag.attr("href"));
			}
			File newFile = new File("links_to_faculty_profiles.csv");
			newFile.createNewFile();
			FileWriter writer = new FileWriter("links_to_faculty_profiles.csv");
			writer.write("Faculty Name,Link to Profile\n");
			for(String url:department_faculties){
				document = Jsoup.connect(url).get();
				Elements anchorTags = document.body().select("div#block-system-main a");
				for(Element tag: anchorTags){
					String name = tag.text();
					String link = BASE_URL + tag.attr("href");
					writer.write(name+","+link+"\n");
				}
			}
			writer.close();
		}
		catch(IOException io){
			io.printStackTrace();
		}
	

   }
}