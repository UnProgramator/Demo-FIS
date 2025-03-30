package model.reader;

import model.dataclass.ClientModel;

import java.util.Arrays;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class ClientDbManager {
	public static  ClientModel[] getClients() { 
		ClientModel[] cli;
	      
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		      
		Gson gson = builder.create(); 
		
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader("data/clients.json"));
			cli = gson.fromJson(reader, ClientModel[].class); 
			System.out.println(cli);    
			      
			return cli;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ClientModel[0];		
		}
		
		
	}
	public static void saveClients(ClientModel[] clients) {
		try (FileWriter writer = new FileWriter("data/clients.json")) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(clients, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
