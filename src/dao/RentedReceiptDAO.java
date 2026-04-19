package dao;

import model.Client;
import model.RentedCostume;
import model.RentedDeposit;
import model.RentedReceipt;
import model.ReturnedCostume;
import model.ReturnedReceipt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentedReceiptDAO extends DAO {
    public List<RentedReceipt> searchByClient(Client client) {
        List<RentedReceipt> results = new ArrayList<>();
        if (client == null) {
            return results;
        }
        for (RentedReceipt rentedReceipt : db.getRentedReceipts()) {
            if (rentedReceipt.getClient() != null && rentedReceipt.getClient().getId() == client.getId()) {
                results.add(rentedReceipt);
            }
        }
        return results;
    }

    public boolean checkReturnedDeposit(RentedReceipt rentedReceipt) {
        if (rentedReceipt == null) {
            return false;
        }
        return rentedReceipt.isCompleted();
    }

    public void applyReturnedItemsToRentedReceipt(ReturnedReceipt returnedReceipt) {
        if (returnedReceipt == null || returnedReceipt.getClient() == null) {
            return;
        }

        List<RentedReceipt> rentedReceipts = searchByClient(returnedReceipt.getClient());
        for (ReturnedCostume returnedCostume : returnedReceipt.getListReturnedCostume()) {
            RentedCostume target = returnedCostume.getRentedCostume();
            if (target == null) {
                continue;
            }
            for (RentedReceipt rentedReceipt : rentedReceipts) {
                for (RentedCostume rentedCostume : rentedReceipt.getListRentedCostume()) {
                    if (rentedCostume.getId() == target.getId()) {
                        rentedCostume.addReturnedQuantity(returnedCostume.getQuantity());
                    }
                }
            }
        }

        for (RentedReceipt rentedReceipt : rentedReceipts) {
            updateRentedStatus(rentedReceipt);
            updateDepositStatus(rentedReceipt);
        }
    }

    public boolean updateRentedStatus(RentedReceipt rentedReceipt) {
        if (rentedReceipt == null) {
            return false;
        }
        rentedReceipt.setStatus(rentedReceipt.isCompleted() ? "Da hoan tat" : "Dang thue");
        return true;
    }

    public boolean updateDepositStatus(RentedReceipt rentedReceipt) {
        if (rentedReceipt == null || rentedReceipt.getListRentedDeposit() == null) {
            return false;
        }
        boolean canReturnDeposit = checkReturnedDeposit(rentedReceipt);
        for (RentedDeposit rentedDeposit : rentedReceipt.getListRentedDeposit()) {
            if (canReturnDeposit) {
                rentedDeposit.setReturned(true);
            }
        }
        return true;
    }
}