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


    public  User login(String username, String password) {
        if ("abe".equals(username) && "password".equals(password)) {
            return new User(username, null);
        } else if ("barb".equals(username) && "password".equals(password)) {
            return new User(username, null);
        } else {
            return null;
        }
    }
}
