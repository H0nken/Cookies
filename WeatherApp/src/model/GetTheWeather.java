package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.Cookie;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class GetTheWeather {

	public static void getWeather(weatherBean wBean) throws IOException {
		
		//String URLtoSend="http://api.openweathermap.org/data/2.5/weather?q=malmo,se&APPID=099eff339f56d6a29a9823857b2f2671&mode=xml";
		
		
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=099eff339f56d6a29a9823857b2f2671&mode=xml";
		
		
		System.out.println(URLtoSend);
		
		
			URL line_api_url = new URL(URLtoSend);
		
		
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		
		linec.setDoInput(true);
		
		linec.setDoOutput(true);
		
		linec.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));
		
		String inputLine;
		
		String ApiResponse = "";
		
		while((inputLine=in.readLine())!= null) {
			
			//System.out.println(inputLine);
		
			ApiResponse += inputLine;
		}
		
		in.close();
		
		System.out.println(ApiResponse);
		
		Document doc = convertStringToXMLDocument(ApiResponse);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: "+ doc.getDocumentElement().getNodeName());
		
		
		NodeList nList = doc.getElementsByTagName("clouds");
		NodeList nList2 = doc.getElementsByTagName("speed");
		//NodeList nList3 = doc.getElementsByTagName("speed");

		
		
		for (int temp=0; temp<nList.getLength(); temp++) {
			
			Node node = nList.item(temp);
			Node node2 = nList2.item(temp);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) node;
				Element eElement2 = (Element) node2;
				
				String XMLClouds = eElement.getAttribute("name");
				String XMLSpeed = eElement2.getAttribute("name");
				
				System.out.println(XMLClouds + XMLSpeed);
				
				
				wBean.setCloudsStr(XMLClouds);
				wBean.setSpeedStr(XMLSpeed);
				
				
				
				
				
			}
			
			
				
		}
		
	}

	private static Document convertStringToXMLDocument(String xmlString) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = null;
		
		try {
			
			 builder = factory.newDocumentBuilder();
			 
			 Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			
			return doc;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
