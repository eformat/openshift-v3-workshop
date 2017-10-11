import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Prep {
    public static void main (String[] args) {
        try {
            File f = new File(".");
            ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
            for (int i=0; i<names.size(); i++) {
                if(names.get(i).endsWith(".md")) {
                    //Read the file in
                    String head = new String("<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<title>OpenShift 3</title>\n" +
                            "\n" +
                            "<xmp theme=\"openshift\" style=\"display:none;\">");

                    String tail = new String("</xmp>\n" +
                            "\n" +
                            "<script src=\"scripts/strapdown.js\"></script>");

                    FileInputStream fis = new FileInputStream(new File(names.get(i)));

                    //Construct BufferedReader from InputStreamReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                    FileWriter fw = new FileWriter(names.get(i) + ".html");
                    fw.write(head + "\n");

                    String line = null;
                    while ((line = br.readLine()) != null) {
                        fw.write(line + "\n");
                    }

                    fw.write("\n\n" + tail);
                    br.close();
                    fw.close();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
