import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//////////// args 1- The path  args 2-output path
public class tasan_assignment2 {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.out.println("Length higher or equal to four");
            System.exit(0);
        }

        if (!(args[0].startsWith("b") && args[0].startsWith("t"))) {
            System.exit(0);
        }
        if (args[0].startsWith("b")) {
            readbinaryfile(args[1], args[2]);


        } else {

            Readfile(args[1], args[2]);


        }
    }

    public static StringBuilder Readfile(String Fileinputpath, String Outputfilepath) throws FileNotFoundException {/// READİNG THE FİLE AND CONVERT TO BİNARY

        try {
            FileInputStream fstream = new FileInputStream(Fileinputpath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {  ///reading the text file when you givr arg[0] file absoulutr path
                System.out.println(strLine);

                ///StringBuilder result = new StringBuilder(); /////// TEXT TO BİNARY//////
               /// char[] chars = strLine.toCharArray();
               /// for (char aChar : chars) {
                  ///  result.append(
                           /// String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                               ///     .replaceAll(" ", "0")                         // zero pads
                  ///  );

             ///   }
                FileInputStream fis = new java.io.FileInputStream(Fileinputpath);
                BufferedInputStream bfıs = new java.io.BufferedInputStream(fis);

                FileWriter fw = new java.io.FileWriter(Outputfilepath);
                PrintWriter pw = new java.io.PrintWriter(new java.io.BufferedWriter(fw));


                byte[] byt = new byte[1];
                String str=null;
                while (bfıs.read(byt)> 0)
                {
                    str = new String(byt);
                    pw.print(str);
                }

                pw.close();
                bfıs.close();


            }
            InputStream inputStream = new FileInputStream(Fileinputpath); //// READİNG BİNARY FİLE///////
            OutputStream outputStream = new FileOutputStream(Outputfilepath);
            int byteRead = -1;

            while ((byteRead = inputStream.read()) != -1) {
                outputStream.write(byteRead);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }






    public static void readbinaryfile(String Binarinputypath ,String Outputfile) throws IOException {
        try {
            FileInputStream filıs = new FileInputStream(Binarinputypath); ////reading binary
            ObjectInputStream objis = new ObjectInputStream(filıs);
            int x = objis.readInt(); //// raeding intigers
            System.out.println(x);
            double d = objis.readDouble(); ///read double
            System.out.println(d);
            ////// second way trying other methods/////////// (READİNG BİNARY)
            java.io.BufferedInputStream bfıs = new java.io.BufferedInputStream(filıs);
            java.io.FileWriter fw = new java.io.FileWriter(Binarinputypath);
            java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.BufferedWriter(fw));
            byte[] byt = new byte[1];
            String str = null;
            while (bfıs.read(byt) > 0) {
                str = new String(byt);
                pw.print(str);
            }

            try {
                java.io.FileInputStream fis = new java.io.FileInputStream(Binarinputypath);
                java.io.BufferedInputStream BF = new java.io.BufferedInputStream(fis);

                java.io.FileWriter FW = new java.io.FileWriter(Outputfile);
                java.io.PrintWriter PW = new java.io.PrintWriter(new java.io.BufferedWriter(fw));


                byte[] BYT = new byte[1];
                String STR = null;
                while (bfıs.read(BYT) > 0) {
                    STR = new String(BYT);
                    pw.print(STR);
                }

                pw.close();
                bfıs.close();
                //////////////////// ///////////


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }






}


/////////////////This assignment was hard to me , I did my best ///////////