import java.io.*;
import java.util.*;
public class Editor extends IOException{
    Vector<String> file = new Vector<String>();
    boolean readFile(String filePath){
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch(FileNotFoundException e){}
        BufferedReader bufread = new BufferedReader(new InputStreamReader(in));
        String str;
        try {
            while ((str = bufread.readLine()) != null){
                file.add(str);
            }
            in.close();
        } catch (IOException e){}
        return true;
    }
    boolean writeFile(String filePath){
        OutputStream out;
        try{
            out = new FileOutputStream(filePath,false);
        } catch(FileNotFoundException e){
            return false;
        }
        BufferedWriter bufwrit = new BufferedWriter(new OutputStreamWriter(out));
        try {
            for (String s:file) {
                bufwrit.write(s+"\n");
            }
            bufwrit.flush();
        }catch (IOException e){
            return false;
        }
        file.clear();
        return true;
    }
    boolean changeWord(String filePath,int Snum, int Wnum, String newW){
        readFile(filePath);
        String[] word = file.elementAt(Snum).split("");
        word[Wnum] = " " + newW + " ";
        StringBuilder builder = new StringBuilder();
        for(String wb:word){
            builder.append(wb);
        }
        file.set(Snum,builder.toString());
        writeFile(filePath);
        return true;
    }
    boolean changeLine(String filePath,int num, String newS){
        readFile(filePath);
        file.set(num,newS);
        writeFile(filePath);
        return true;
    }
}
