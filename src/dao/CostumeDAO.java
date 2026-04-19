package dao;

import model.Costume;

public class CostumeDAO extends DAO {
    public boolean updateQuantity(Costume costume) {
        if (costume == null || costume.getBarcode() == null) {
            return false;
        }
        for (Costume dbCostume : db.getCostumes()) {
            if (dbCostume.getBarcode().equals(costume.getBarcode())) {
                return dbCostume.updateQuantity(costume.getQuantity());
            }
        }
        return false;
    }
}