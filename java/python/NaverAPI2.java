
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NaverAPI2 {
	static final String CLIENT_ID = "shlF6m5AhaeHVx6mtCt9";
	static final String CLIENT_SECRET = "0EoULsJdol";
	static final String HEADER_CLIENT_ID = "X-Naver-Client-Id";
	static final String HEADER_CLIENT_SECRET= "X-Naver-Client-Secret";


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "";
		final String baseURL = "https://openapi.naver.com/v1/search/news.json?"; 
		final String query = "query";      String queryValue = "гиеве╘";
		final String display = "display";  String dispaly_val = "10";
		final String start = "start";      String start_val = "1";
		final String sort = "sort";        String sort_val ="sim";
		QueryString qs = new QueryString();
		qs.add(query, queryValue);
		qs.add(display, dispaly_val);
		qs.add(start, start_val);
		qs.add(sort, sort_val);

		URL = baseURL + qs.getQuery();
		
		InputStream raw = null;

		try {
			URL u = new URL(URL);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setRequestMethod("GET");
			//set Headers
			uc.setRequestProperty(HEADER_CLIENT_ID, CLIENT_ID);
			uc.setRequestProperty(HEADER_CLIENT_SECRET, CLIENT_SECRET);
			System.out.println("request URL: " + uc.getURL());
			System.out.println();
			System.out.println("++++++ Start of HTTP response message++++++");
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
			System.out.println("++++++End of HTTP response message++++++\n");

			StringBuffer sb = new StringBuffer();
			raw = uc.getInputStream();
			InputStream buffer = new BufferedInputStream(raw);
			BufferedReader reader = new BufferedReader(new InputStreamReader(buffer, "UTF-8")) ;

			String line;
			while((line = reader.readLine()) != null  )
				sb.append(line + "\n");

			JSONParser jsonParser = new JSONParser();
			try {

				JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString()); 
				JSONArray jsonArray = (JSONArray)jsonObject.get("items"); 

				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObj = (JSONObject)jsonParser.parse(jsonArray.get(i).toString());
					String title = (String) jsonObj.get("title");
					String link = (String) jsonObj.get("link");
					System.out.println(title + " : " + link);
				}
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raw != null) {
				try {
					raw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}