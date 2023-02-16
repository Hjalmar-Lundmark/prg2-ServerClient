package Client;

public class StartC {
    public static void main(String[] args) {
        ViewC theView = new ViewC();
        ModelC theModel = new ModelC();
        ControllerC theControllertest = new ControllerC(theView,theModel);
    }
}
