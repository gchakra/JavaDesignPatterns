
package javdpattern;

/**
 *
 * @author gopalchakravarthy
 */

/*
In the above class diagram we have an interface called Notification, and three concrete 
classes are implementing Notification interface. 
A factory class NotificationFactory is created to get a Notification object
*/
public interface Notification {
    void notifyUser(String fileName);
    
}
