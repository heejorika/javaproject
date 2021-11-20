import javax.swing.*;
import java.util.ArrayList;
import java.lang.*;

public class testClass {
    public static void main(String[] args) {
        ArrayList<String> name_list = new ArrayList<String>();
        ArrayList<String> ID_list = new ArrayList<String>();
        ArrayList<String> PW_list = new ArrayList<String>();

        ID_list.add("dd");
        int ID_index=ID_list.indexOf("dd");
        
        name_list.add("성민");
        System.out.println(name_list.get(ID_index));

    }
}
