package nio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Nio {

    public static void main(String[] args) throws IOException, DocumentException {
        new Nio().Reader();
        new Nio().Writer();
    }

    public void Writer() throws IOException, DocumentException {
        Document document = new Document();

        System.out.println("Введите текст: \n");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();


        PdfWriter.getInstance(document, new FileOutputStream("src/main/java/nio/in/nio.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
        Chunk chunk = new Chunk(str, font);

        document.add(chunk);
        document.close();
    }


    public void Reader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/nio/out/nio.csv"));

        String line = null;
        Scanner scanner = null;
        int x = 0;
        List<Notebook> list = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            Notebook note = new Notebook();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String str = scanner.next();
                if (x == 0) {
                    note.setId(Integer.parseInt(str));
                } else if (x == 1) {
                    note.setFirmNotebook(str);
                } else if (x == 2) {
                    note.setPrice(str);
                } else {
                    System.out.println("Введены некоректные данные: " + str);
                }
                x++;
            }
            x = 0;
            list.add(note);
        }

        bufferedReader.close();

        System.out.println(list);
    }
}
