package com.soccer.www.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class getYoutubeController {
	
	@RequestMapping(value = "/main.do")
	public String getYoutube(Model model, String id) {
		
		String API_KEY = "AIzaSyCWffLkLhNuI6zzuBRNSRpHU2zDYqNZu5c";
		try {
			
			String youtube = "https://www.googleapis.com/youtube/v3/videos?id=" +
					"7lCDEYXw3mM"
					+"&key="
					+API_KEY
					+"&part=snippet,contentDetails,statistics,status";
			
			BufferedReader br;
			URL url = new URL(youtube);
		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("content-type", "apllication/json");
			
			br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String result = "";
			while((line=br.readLine())!=null) {
				result=result.concat(line);
			}
			
		
			
			
//			JsonParser parser = new JsonParser();
//			JsonObject kind = (JsonObject)parser.parse(result);
//			System.out.println(kind);
//			
//			JsonArray items = (JsonArray)kind.get("items");
//			
//			
//			JsonObject snippet = (JsonObject) ((JsonObject) items.get(0)).get("snippet");
//			JsonObject thumbnails = (JsonObject)snippet.get("thumbnails");
//			JsonObject def = (JsonObject)thumbnails.get("default");
//			JsonObject medium = (JsonObject)thumbnails.get("medium");
//			JsonObject high = (JsonObject)thumbnails.get("high");
//			JsonObject contentDetails = (JsonObject)((JsonObject)items.get(0)).get("contentDetails");
//			JsonObject statistics = (JsonObject)((JsonObject)items.get(0)).get("statistics");
//			System.out.println("3번째 인덱스++++++++++++++++++++++"+items.get(0));
//			
//			System.out.println("컨텐츠 디테일 ============"+ contentDetails);
//			
//			System.out.println("===================================" + statistics);
//			model.addAttribute("content", contentDetails);
//			
//			model.addAttribute("statistics", statistics);
			
			
	
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "main";
	}
	


}
