package com.login;

public class AuthenticationService {

    UserRepository repository = new UserRepository();

    public Boolean authenticate(Integer userId, String password) {
        return repository.userExists(userId) && repository.getPassword(userId).equals(password);
    }
}
