import java.util.*;
public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\днс\\test.txt";
        Editor txt = new Editor();
        txt.changeWord(filePath,8,2,"New world");
        txt.changeLine(filePath,3,"New string");
    }
}