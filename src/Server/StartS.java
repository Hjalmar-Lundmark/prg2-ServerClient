package Server;

public class StartS {
    public static void main(String[] args) {
        ViewS theView = new ViewS();
        ModelS theModel = new ModelS();
        ControllerS theControllertest = new ControllerS(theView,theModel);
    }
}
