package dao;

import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO {
    public List<Client> searchClient(Client criteria) {
        List<Client> results = new ArrayList<>();
        if (criteria == null) {
            return results;
        }

        String fullname = normalize(criteria.getFullname());
        String email = normalize(criteria.getEmail());
        String tel = normalize(criteria.getTel());

        for (Client client : db.getClients()) {
            boolean matchFullname = fullname.isEmpty() || normalize(client.getFullname()).contains(fullname);
            boolean matchEmail = email.isEmpty() || normalize(client.getEmail()).contains(email);
            boolean matchTel = tel.isEmpty() || normalize(client.getTel()).contains(tel);
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