
package models;

/**
 *
 * @author 738634
 */
public class AccountService {
    
    User bruce = new User("Bruce","password");
    User adam = new User("Adam","password");
    
    public User login(String username, String password)
    {
       User user = null;
        
       if(username.equals(bruce.getUserName())&& password.equals(bruce.getUserPassword()))
       {
           user = new User(username, null);
       }
       else if(username.equals(adam.getUserName()) && password.equals(bruce.getUserPassword()))
       {
           user = new User(username, null);
       }
       
       return user;
    }
    
}
