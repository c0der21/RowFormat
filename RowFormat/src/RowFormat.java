import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class RowFormat
{

    public static void main(String[] args)
    {
        new RowFormat().start();
    }

    public void start()
    {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите длину строки: ");
            int rowLength = scan.nextInt();
            System.out.print("Введите имя файла: ");
            String fileName = scan.next();
            File fileDir = new File(fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir)));
            String str;
            String text = "";
            while ((str = in.readLine()) != null)
            {
                text += str + " ";
            }
            in.close();
            System.out.println("Текст:");
            System.out.println(text);
            Writer writer = new OutputStreamWriter(new FileOutputStream("result.txt"));
            BufferedWriter fout = new BufferedWriter(writer);
            massive m = new massive(text, rowLength);
            fout.write(m.format(m));
            fout.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static String cut(String str, int rowLength)
    {
        String result = "";
        while (str.length() >= rowLength)
        {
            String row = "";
            int firstVowel = firstVowel(str);
            if (firstVowel != -1)
            {
                row += str.substring(0, firstVowel + 1) + "-";
            }
            for (int j = 0; j < rowLength - row.length(); j++)
            {
                row += " ";
            }
            str = str.substring(firstVowel + 1);
            result += row + "\r\n";
        }
        result += str + "\r\n";
        return result;
    }



    private static int firstVowel(String str)
    {
        char[] vowel = {'e', 'E', 'y', 'Y', 'u', 'U', 'i', 'I', 'o', 'O', 'a', 'A',  'е', 'Е', 'ы', 'Ы', 'а', 'А', 'о', 'О', 'э', 'Э', 'я', 'Я', 'и', 'И', 'ю', 'Ю'};
        for (int i = 0; i < str.toCharArray().length; i++)
        {
            for (char v : vowel)
            {
                if (str.charAt(i) == v)
                {
                    return i;
                }
            }
        }
        return -1;
    }

}

