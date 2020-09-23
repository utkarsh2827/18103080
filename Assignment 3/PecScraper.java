import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;
public class PecScraper {
	public static void print(String msg){
		System.out.print(msg);
	}
   	public static void main(String[] args){
   		print("Started Scraping!\n");
		try{
			Document document = Jsoup.connect("http://pec.ac.in").get();
			System.out.println(document.title());
			Elements tags = document.body().select("*");
			File newFile = new File("tags_text.csv");
			newFile.createNewFile();
			FileWriter writer = new FileWriter("tags_text.csv");
			writer.write("Tags,Text\n");
			for (Element tag : tags) {
				String tagName = tag.tagName();
				String tagText = "\""+tag.ownText()+"\"";
			    if(tagText!=null&&tagText.length()>2)writer.write(tagName+","+tagText+"\n");
			}
			writer.close();
			newFile = new File("anchor_tags.csv");
			newFile.createNewFile();
			writer = new FileWriter("anchor_tags.csv");
			writer.write("Text,Url\n");
			Elements links = document.select("a[href]");
			Set<String> set = new HashSet<String>();
			for(Element link: links){
				String linkText = "\""+link.text()+"\"";
				String linkUrl = link.attr("href");
				if(set.add(linkUrl))
					writer.write(linkText+","+linkUrl+"\n");
			}
			writer.close();
			print("Scraping finished!\n");
		}
		catch(IOException io){
			io.printStackTrace();
		}
		

   }
}