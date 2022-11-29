package graphics;
import java.util.Observable;
import java.util.Observer;

public class Controller  implements Observer {
    private static Controller  controller_instance = null;
    private Controller(){}
    public static Controller getController(){
        if (controller_instance == null){
            controller_instance = new Controller();
        }
        return controller_instance;
    }


    public synchronized void update(Observable o, Object arg) {

        if(arg instanceof ZooPanel){
            ((ZooPanel) arg).manageZoo();
        }
    }
}
