package dao;

import model.User;

public class UserDAO extends DAO {
    public boolean checkLogin(User user) {
        if (user == null) {
            return false;
        }
        for (User dbUser : db.getUsers()) {
            if (dbUser.getUsername().equals(user.getUsername())
                    && dbUser.getPassword().equals(user.getPassword())) {
                user.setId(dbUser.getId());
                user.setFullname(dbUser.getFullname());
                user.setRole(dbUser.getRole());
                return true;
            }
        }
        return false;
    }
}