package leSuperCoin.model.dao;

import leSuperCoin.model.entities.User;
import leSuperCoin.model.entities.ValeurCritere;

import java.util.Collection;

public interface UserDao extends Dao<User>{

    public User findUserByLoginAndPasse(String login,String mdp);
}
