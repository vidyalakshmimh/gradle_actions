package org.sherwin.pages;

import org.sherwin.maps.LoginMap;
import org.sherwin.utilities.BaseCommands;

import java.util.Base64;

public class LoginPage {
    LoginMap loginmap=new LoginMap();

    public String decodeString(){
        String encryptData="password";
        byte[] encodeBytes= Base64.getEncoder().encode(encryptData.getBytes());
        return (new String(encodeBytes));
    }
    public void loginToGL(String Username, String password){
        BaseCommands.sendKeys(loginmap.userId(),Username,"user name");
//        String encryptData="password";v new String(encodeBytes)
//        byte[] encodeBytes= Base64.getEncoder().encode(encryptData.getBytes());
        BaseCommands.sendKeys(loginmap.pwd(),password,"password");
        BaseCommands.click(loginmap.submitButton(),"submit");
    }
    public void logoutFromUserProfile()
    {
        BaseCommands.click(loginmap.clickOnUserProfile(),"user profile");
        BaseCommands.click(loginmap.clickOnSignOut(),"sign out");
    }

}

