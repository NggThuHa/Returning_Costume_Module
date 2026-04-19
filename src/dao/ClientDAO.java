package dao;

import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO {
    public List<Client> searchClient(String fullname, String email, String tel) {
        List<Client> results = new ArrayList<>();
        String fn = normalize(fullname);
        String em = normalize(email);
        String tl = normalize(tel);

        for (Client client : db.getClients()) {
            boolean matchFullname = fn.isEmpty() || normalize(client.getFullname()).contains(fn);
            boolean matchEmail    = em.isEmpty() || normalize(client.getEmail()).contains(em);
            boolean matchTel      = tl.isEmpty() || normalize(client.getTel()).contains(tl);
            if (matchFullname && matchEmail && matchTel) {
                results.add(client);
            }
        }
        return results;
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase();
    }
}