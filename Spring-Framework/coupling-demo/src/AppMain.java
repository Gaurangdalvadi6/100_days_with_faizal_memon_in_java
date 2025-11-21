import loose.EmailNotificationService;
import loose.NotificationService;
import loose.SmsNotification;
import tight.UserService;

public class AppMain {
    public static void main(String[] args) {
        // tight
        UserService userService = new UserService();
        userService.notifyUser("Order Placed!");

        // loose
        NotificationService notificationService = new EmailNotificationService();
        loose.UserService userService1 = new loose.UserService(notificationService);
        userService1.notifyUser("Order Placed Using loose coupling!!");

        NotificationService smsNotification = new SmsNotification();
        loose.UserService userService2 = new loose.UserService(smsNotification);
        userService2.notifyUser("sms notificationService");

        loose.UserService userServicelooseSetter = new loose.UserService();
        userServicelooseSetter.setNotificationService(smsNotification);

        userServicelooseSetter.notificationService = smsNotification;
    }
}
