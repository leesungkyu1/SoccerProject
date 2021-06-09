package com.soccer.www.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class getYoutubePlaylist {

	@RequestMapping(value = "/playlist.do")
	   @ResponseBody
	   public String getYoutubeChannel(Model model) {

	      String API_KEY = "AIzaSyCWffLkLhNuI6zzuBRNSRpHU2zDYqNZu5c";

	      String rslt = "";
	      
	      try {

	         String channel = "https://www.googleapis.com/youtube/v3/playlistItems?playlistId="
	               + "PLrblLDwXP6Vtv-0jAsTepOkNa0Y7MXw88" // channels 아이디
	               + "&key=" 
	               + API_KEY 
	               + "&part=snippet,id"
	               + "&maxResults=50";

	         BufferedReader br;
	         URL url = new URL(channel);

	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         conn.setRequestProperty("content-type", "apllication/json");

	         br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	         String line = "";
	         String result = "";
	         while ((line = br.readLine()) != null) {
	            result = result.concat(line);
	         }

	         JSONParser parser = new JSONParser();
	         JSONObject kind = (JSONObject) parser.parse(result);
	         JSONArray items = (JSONArray) kind.get("items");

	         rslt = kind.toJSONString();
	         
	         System.out.println(rslt);
	      } catch (IOException | ParseException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return rslt;

	   }
		
		@RequestMapping(value = "/test")
		public String test() {
		      return "test";
		   }
		
		@RequestMapping(value ="/view.do")
		public String view() {
			return "youtubeView";
		}
}