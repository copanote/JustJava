
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NaverAPI {
	static final String CLIENT_ID = "shlF6m5AhaeHVx6mtCt9";
	static final String CLIENT_SECRET = "0EoULsJdol";
	static final String HEADER_CLIENT_ID = "X-Naver-Client-Id";
	static final String HEADER_CLIENT_SECRET= "X-Naver-Client-Secret";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "";
		final String baseURL = "https://openapi.naver.com/v1/search/news.json?"; 
		final String query = "query";      String queryValue = "스타크래프트";
		final String display = "display";  String dispaly_val = "100";
		final String start = "start";      String start_val = "10";
		final String sort = "sort";        String sort_val ="sim";
		QueryString qs = new QueryString();
		qs.add(query, queryValue);
		qs.add(display, dispaly_val);
		qs.add(start, start_val);
		qs.add(sort, sort_val);
		
		URL = baseURL + qs.getQuery();
		
		try {
			URL u = new URL(URL);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setRequestMethod("GET");
			//set Headers
			uc.setRequestProperty(HEADER_CLIENT_ID, CLIENT_ID);
			uc.setRequestProperty(HEADER_CLIENT_SECRET, CLIENT_SECRET);
			System.out.println(uc.getURL());
			
			for(int j = 0; ; j++) {
				String header = uc.getHeaderField(j);
				if (header == null) {
					break;
				}
				if (j == 0)
					System.out.println(header);
				else
					System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
			}
			
			StringBuffer sb = new StringBuffer();
			InputStream raw = uc.getInputStream();
			InputStream buffer = new BufferedInputStream(raw);
			BufferedReader reader = new BufferedReader(new InputStreamReader(buffer, "UTF-8")) ;
	
			String line;
			while((line = reader.readLine()) != null  ) {
				//System.out.println(line);
				sb.append(line+ "\n");
			}
			List<String> list_item = parsingJSON(sb.toString(), "items");
			
			
			for (int i = 0; i < list_item.size() ; i++) {
				String result = list_item.get(i).toString();
//				List<String> list_title = parsingJSON(result, "title");
//				List<String> list_link = parsingJSON(result, "link");
//				System.out.println(list_title.get(i));
//				System.out.println(list_link.get(i));
				
				JSONParser jsonParser = new JSONParser();
				try {
					JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
					String items = (String) jsonObject.get("title");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(result);
				
			}

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> parsingJSON(String jsonStr, String key) {
		List<String> list = new ArrayList<String>();
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonStr);
			list = (List<String>) jsonObject.get(key);
//			System.out.println(list.toString());
//			for (int i = 0; i < list.size(); i++) 
//				list.add(items.get(i).toString());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}