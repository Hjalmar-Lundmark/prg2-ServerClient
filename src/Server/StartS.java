package Server;

public class StartS {
    public static void main(String[] args) {
        ViewS theView = new ViewS();
        ModelS theModel = new ModelS(1234);
        ControllerS theControllertest = new ControllerS(theView,theModel);
    }
}
