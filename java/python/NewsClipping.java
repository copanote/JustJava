import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsClipping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "http://www.yonhapnews.co.kr/bulletin/0200000001.html?template=5543";
		InputStream raw = null;
		InputStream buffer = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(baseUrl);
			StringBuffer sb = new StringBuffer();
			raw = url.openStream();
			buffer = new BufferedInputStream(raw);
			reader = new BufferedReader(new InputStreamReader(buffer, "UTF-8"));
			
			String line;
			while ((line = reader.readLine()) != null ) { 
				sb.append(line);
			}
			
			Document doc = Jsoup.parse(sb.toString());
			Elements resultLinks = doc.select("#content > div.contents > div.contents01 > div > div.headlines.headline-list > ul > li");
			for (Element element : resultLinks) {
				Elements a_str = element.select("a[href]");
				
				for (int i = 0; i < a_str.size(); i++) {
					if (i == 0) {
						Element ele = a_str.get(i);
						String text = ele.text();
						String link = ele.attr("href");	
						System.out.println(link + " : " + text);
						
						URL article = new URL(link);
//						InputStream article_raw = article.openStream();
//						InputStream article_buffer = new BufferedInputStream(article_raw);
//						BufferedReader article_reader = new BufferedReader(new InputStreamReader(article_buffer, "UTF-8"));
						raw = article.openStream();
						buffer =  new BufferedInputStream(raw);
						reader = new BufferedReader(new InputStreamReader(buffer, "UTF-8"));
						String line2;
						StringBuffer sb2 = new StringBuffer();
						while ((line2 = reader.readLine()) != null )
							sb2.append(line2 + "\n");
						doc = Jsoup.parse(sb2.toString());
						Elements article_text = doc.select("#articleWrap > div.article > p");
						String str_article=article_text.text();
						System.out.println(str_article);

					}
					
				}
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (raw != null) {
				try {
					raw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

}
