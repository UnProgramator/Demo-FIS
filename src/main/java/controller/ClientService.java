package controller;

import java.util.ArrayList;
import java.util.Arrays;

import model.dataclass.ClientModel;
import model.reader.ClientDbManager;

public class ClientService {
	public static void saveClient(int id, String nume, String nrTel) throws Exception {
		ClientModel[] cl = ClientDbManager.getClients();
		ArrayList<ClientModel> li = new ArrayList<ClientModel>( Arrays.asList(cl));
		
		for(ClientModel m : cl) {
			if(m.id == id) {
				throw new Exception();
			}
		}
		
		li.add(new ClientModel(id, nume, nrTel));
		ClientDbManager.saveClients(li.toArray(new ClientModel[0]));
	}
	
	public static ClientModel[] getAllClients() {
		return ClientDbManager.getClients();
	}
}
