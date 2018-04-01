/*
Java program that will translate any int number to the letter equivalent -- romanian
input: 256
output: "doua sute cincizeci si sase de lei"
 */


package interviu10;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interviu10 {

   //dictionar cu valorile numerelor simple
   Map<Integer, String> dictionarCifre;{

        dictionarCifre = new HashMap<Integer, String>();
        //fill dict val simple
        dictionarCifre.put(0, "");
        dictionarCifre.put(1, "unu");
        dictionarCifre.put(2, "doi");
        dictionarCifre.put(3, "trei");
        dictionarCifre.put(4, "patru");
        dictionarCifre.put(5, "cinci");
        dictionarCifre.put(6, "sase");
        dictionarCifre.put(7, "sapte");
        dictionarCifre.put(8, "opt");
        dictionarCifre.put(9, "noua");
        dictionarCifre.put(10, "zece");
        dictionarCifre.put(11, "unsprezece");
        dictionarCifre.put(12, "doisprezece");
        dictionarCifre.put(13, "tresprezece");
        dictionarCifre.put(14, "paisprezece");
        dictionarCifre.put(15, "cinsprezece");
        dictionarCifre.put(16, "saisprezece");
        dictionarCifre.put(17, "saptesprezece");
        dictionarCifre.put(18, "optsprezece");
        dictionarCifre.put(19, "nouasprezece");}


    //dictionar cu valorile numerelor speciale
    Map<Integer, String> dictionarSpecial;{
        dictionarSpecial = new HashMap<Integer, String>();
        //fill dictionar valori speciale
        dictionarSpecial.put(1, "o");
        dictionarSpecial.put(2, "doua");
        dictionarSpecial.put(3, "un");}

    //numarul de transformat in litere
    //main function
    public static void main(String[] args) {
        Interviu10 Interviu10 = new Interviu10();
        int numar;
        Scanner in = new Scanner(System.in);
        System.out.printf("Introduceti numarul:  ");

        //scan for integers
        if(in.hasNextInt()){
            numar = in.nextInt();
         int i = numar;
        int k = 0;


        //err catch >=0
        if (numar>=0){
            //verificam cat de lung e numarul
            while (i>0){
              i = i/10;
             k = k+1;
            }

            String prnt = printeaza(k, numar);
            System.out.printf(prnt +" lei ");
            }
        else{System.out.printf("valoarea trebuie sa fie mai mare ca 0");}





        }else{
                System.out.printf("valoarea trebuie sa fie integer");}


    }

    //existenta cuvantului de legatura
       public static String legatura(int no){
        if (no != 0){
            return " si ";
        } else {return "";}

    }


    //ordinul 1

    public static String undigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        rasp = Interviu10.dictionarCifre.get(nom);

       return rasp;
       }


    //ordinul zecilor

    public static String douadigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp = "aaa";
            if (nom/10 <2){
                rasp = (Interviu10.dictionarCifre.get(nom));
            }
            else if (nom/10 == 2){
                rasp = (Interviu10.dictionarSpecial.get(2)+" zeci" + legatura(nom%10) + Interviu10.dictionarCifre.get(nom%10));
            } else if(nom/10 > 2){
                rasp = (Interviu10.dictionarCifre.get(nom/10)+" zeci" + legatura(nom%10) + Interviu10.dictionarCifre.get(nom%10));
            }

       return rasp;
       }


    //ordinul sutelor

    public static String tridigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp = "aaa";

            if (nom/100 <2){
                rasp = (Interviu10.dictionarSpecial.get(1)+" suta "+douadigits(nom%100));
            }
            else if (nom/100 == 2){rasp = Interviu10.dictionarSpecial.get(2)+" sute "+ douadigits(nom%100);
            }
            else if(nom/100 > 2){
                rasp = (Interviu10.dictionarCifre.get(nom/100)+" sute " + douadigits(nom%100));
            }

        return rasp;

    }

    //ordinul miilor
    public static String patrudigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp = "ss";

            if (nom/1000 <2){
                rasp = (Interviu10.dictionarSpecial.get(1)+" mie "+tridigits(nom%1000));
            }
            else if (nom/1000 == 2){rasp = Interviu10.dictionarSpecial.get(2)+" mii "+ tridigits(nom%1000);
            }
            else if(nom/1000 > 2){
                rasp = (Interviu10.dictionarCifre.get(nom/100)+" mii " + tridigits(nom%1000));
            }

        return rasp;

    }


    //ordinul zecilor de mii
    public static String cincidigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        rasp = douadigits(nom/1000)+" de mii "+ tridigits(nom % 100);

       return rasp;
       }


    //ordinul sutelor de mii
    public static String sasedigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        rasp = tridigits(nom/1000)+" de mii "+ tridigits(nom % 1000);

       return rasp;
       }

    //ordinul milioanelor
    public static String saptedigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        if (nom/1000000 < 2){
        rasp = "un milion "+ sasedigits(nom % 10000);}
        else {rasp = undigits(nom/1000000)+" milioane "+ sasedigits(nom % 10000);}


       return rasp;
       }

    //ordinul zecilor de milioane
    public static String optidigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        rasp = douadigits(nom/1000000)+" de milioane "+ sasedigits(nom % 1000000);

       return rasp;
       }

    //ordinul sutelor de milioane
    public static String nouadigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        rasp = tridigits(nom/1000000)+" de milioane "+ sasedigits(nom % 1000000);

       return rasp;
       }

    //ordinul miliardelor
    public static String zecedigits(int nom){
        Interviu10 Interviu10 = new Interviu10();
        String rasp;
        if (nom/1000000000 == 1){
        rasp = "un miliard "+ nouadigits(nom % 1000000000);}
        else {rasp = undigits(nom/1000000000)+" miliarde "+ nouadigits(nom % 1000000000);}


       return rasp;
       }

       //printeaza outputul

    public static String printeaza(int k, int numar){
           //instanciate 4 dictionary access in static method
           Interviu10 Interviu10 = new Interviu10();
           String answer = "aaa";

            switch (k){
                case 0: answer = "zero lei";
                break;
                case 1: answer = undigits(numar);
                break;
                case 2: answer = douadigits(numar);
                break;
                case 3: answer = tridigits(numar);
                break;
                case 4: answer = patrudigits(numar);
                break;
                case 5: answer = cincidigits(numar);
                break;
                case 6: answer = sasedigits(numar);
                break;
                case 7: answer = saptedigits(numar);
                break;
                case 8: answer = optidigits(numar);
                break;
                case 9: answer = nouadigits(numar);
                break;
                case 10: answer = zecedigits(numar);
                break;

        }


       return answer;

       }





}
