package leSuperCoin.model.dao;

import leSuperCoin.model.entities.UserEntity;

import java.util.Collection;

public interface UserDao extends Dao<UserEntity>{

    public UserEntity findUserByLoginAndPasse(String login, String mdp);
}
