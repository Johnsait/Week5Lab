/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author JohnC. <john.crudo@edu.sait.ca>
 */
public class AccountService {

    public String username;
    public String password;

    //Constructors
    public AccountService() {
    }

    public AccountService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public  AccountService login(String username, String password) {
        if ("abe".equals(username) && "password".equals(password)) {
            return new AccountService(username, password);
        } else if ("barb".equals(username) && "password".equals(password)) {
            return new AccountService(username, password);
        } else {
            return null;
        }
    }
}
