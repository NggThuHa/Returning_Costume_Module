package dao;

import model.Client;
import model.ReturnedReceipt;

import java.util.ArrayList;
import java.util.List;

public class ReturnedReceiptDAO extends DAO {
    public boolean addReturnedReceipt(ReturnedReceipt returnedReceipt) {
        if (returnedReceipt == null || returnedReceipt.getListReturnedCostume() == null
                || returnedReceipt.getListReturnedCostume().isEmpty()) {
            return false;
        }
        returnedReceipt.setId(db.getReturnedReceipts().size() + 1);
        db.getReturnedReceipts().add(returnedReceipt);
        return true;
    }

    public List<ReturnedReceipt> searchByClient(Client client) {
        List<ReturnedReceipt> results = new ArrayList<>();
        if (client == null) {
            return results;
        }
        for (ReturnedReceipt returnedReceipt : db.getReturnedReceipts()) {
            if (returnedReceipt.getClient() != null && returnedReceipt.getClient().getId() == client.getId()) {
                results.add(returnedReceipt);
            }
        }
        return results;
    }
}