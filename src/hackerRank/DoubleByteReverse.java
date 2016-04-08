package hackerRank;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.xml.bind.DatatypeConverter;

public class DoubleByteReverse {

   public static void main(String args[]) {

      try{                    
             String a = new String("基本形");

             System.out.println("a value "+a);

             String b=new String(a.getBytes("UTF-8"));

             System.out.println("b value "+b);

             String c=new String(b.getBytes("UTF-8"));

             System.out.println("c value "+c);

             String g = new String("ã1áÃã°");
             System.out.println("g value "+g);
             String x = "0x0E";
            byte[] bytes = hexStringToByteArray(x);
            String st = new String(bytes,"UTF-8");
            //System.out.println(st);

             String y = "0x0F";
            byte[] bytes1 = hexStringToByteArray(y);
            String en = new String(bytes1,"UTF-8");
            //System.out.println(en);

            Charset.forName("UTF-8").encode(st);
            System.out.println(DatatypeConverter.printHexBinary(bytes1));
             String finalstring =new String(st+g+en);

             System.out.println("whole string "+finalstring);

             String output=new String(finalstring.getBytes("utf-8"));

             System.out.println("output  "+output);

              }
             catch (UnsupportedEncodingException e){}
      }


   public static byte[] hexStringToByteArray(String hex) {
       int l = hex.length();
       byte[] data = new byte[l/2];
       for (int i = 0; i < l; i += 2) {
           data[i/2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                                + Character.digit(hex.charAt(i+1), 16));
       }
       return data;
   }


}
