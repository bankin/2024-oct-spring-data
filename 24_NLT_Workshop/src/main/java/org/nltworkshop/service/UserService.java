package org.nltworkshop.service;

import org.nltworkshop.web.models.UserLoginModel;
import org.nltworkshop.web.models.UserRegisterModel;

public interface UserService {
    boolean validateRegisterModel(UserRegisterModel userRegisterModel);

    void registerUser(UserRegisterModel userRegisterModel);

    boolean loggedIn(UserLoginModel userLoginModel);
}
