import frame.MainWindow;

public class Main {
    public static void main(String[] args){
        if(args.length > 0) // don't take any argument
            System.exit(0);

        MainWindow mainWindow = new MainWindow();
    }
}
