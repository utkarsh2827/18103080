import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;
import org.jsoup.UnsupportedMimeTypeException;
public class PdfScraper{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		print("Enter seed URL:\n");
		String seedUrl = sc.next();
		Set<String> visitedUrls = new HashSet<String>();
		Set<String> pdfUrls = new HashSet<String>();
		ArrayList<String> urls = new ArrayList<String>();
		urls.add(seedUrl);
		visitedUrls.add(seedUrl);
		try{
			File f = new File("pdf_links.csv");
			f.createNewFile();
			FileWriter writer = new FileWriter("pdf_links.csv");
			writer.write("Text,Links\n");
			int i = 0;
			while(i<urls.size()&&i<=200){
				Document doc;
				try{
					doc = Jsoup.connect(urls.get(i)).get();
				}
				catch(UnsupportedMimeTypeException e){
					
					print("Cannot Scrape: "+ urls.get(i)+"\n");
					i++;
					continue;
				}

				Elements anchorTags = doc.body().select("a");
				for(Element tag : anchorTags){
					String link = tag.attr("href");
					link = link.startsWith("/")?seedUrl+link:link;
					if(link.endsWith(".pdf")||link.endsWith(".PDF")){
						String text = "\""+tag.text()+"\"";
						if(pdfUrls.add(link))writer.write(text+","+link+"\n");
					}
					else if(!link.startsWith("#")&&link.startsWith(seedUrl)){
						if(visitedUrls.add(link)){
							urls.add(link);
						}
					}
				}
				Elements iframes = doc.body().select("iframe.pdf");
				for(Element iframe: iframes){
					String link = iframe.attr("data-src");
					if(link.endsWith(".pdf")){
						link = link.startsWith("/")?seedUrl+link:link;
						if(pdfUrls.add(link))writer.write("iframe"+","+link+"\n");
					}
				}
				i++;
			}
			writer.close();
		}
		catch(IOException io){
    		io.printStackTrace();
    	}
	}
}