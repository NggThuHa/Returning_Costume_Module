package dao;

import model.Damage;

public class DamageDAO extends DAO {
    public boolean addDamage(Damage damage) {
        if (damage == null || !damage.addDamage()) {
            return false;
        }
        damage.setId(db.getDamages().size() + 1);
        db.getDamages().add(damage);
        return true;
    }
}