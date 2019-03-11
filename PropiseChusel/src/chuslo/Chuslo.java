
package chuslo;

import java.util.Scanner;


public class Chuslo {
    Scanner in = new Scanner(System.in);
    private int number;
    private int length_number;

    public void setNumber(int n) {
        number = n;
        lengthnumber();
    }

    public int getNumber() {
        return number;
    }

    public void setLength_number(int n) {
        length_number = n;

    }

    public int getLength_number() {
        return length_number;
    }

    public int lengthnumber() {
        String pr = Integer.toString(number);
        setLength_number(pr.length());
        return length_number;
    }

    //////////////////////////////////////////////////////////
    private String addPenny() {
        String result = " 00 копійок";
        return result;
    }

    private String addTysiach(int thous) {
        //System.out.println("Викликано метод addTysiach");
        String result = "";
        String valut[] = {"тисяча", "тисячі", "тисяч"};
        if (thous >= 20 && thous < 100000) thous %= 10;
        if (thous == 1) result = valut[0];
        if (thous >= 2 && thous < 5) result = valut[1];
        if (thous >= 5 && thous < 10) result = valut[2];
        if (thous >= 10 && thous < 20) result = valut[2];
        //  else result=valut[2];
        return result;
    }

    private String addMillion(int million) {
        //System.out.println("Викликано метод addMillion");
        String result = "";
        String valut[] = {"мільйон", "мільйони", "міліонів"};
        if (million < 10 && million > 0) {
            result = valut[1];
        }
        return result;
    }

    private String addString() {
        //System.out.println("Викликано метод addString");
        String result = "";
        String valut[] = {"гривень", "гривня", "гривні", "гривень"};
        byte chyslo = (byte) (number % 100);
        switch (chyslo) {
            case 1:
                result = valut[1];
                break;
            case 2:
                result = valut[2];
                break;
            case 3:
                result = valut[2];
                break;
            case 4:
                result = valut[2];
                break;
            default:
                result = valut[3];
                break;
        }
        return result;
    }

    ////////////////////////////////////////////////////////
    private String unit(int number) {
        //System.out.println("Викликано метод unit");
        String result = "";

        if (length_number == 1 && number >= 0 && number < 10) {

            String unit[] = {"", "одна", "дві", "три", "чотири", "п'ять", "шість", "сім", "вісім", "дев'ять"};
            if (number == 0) result = "нуль";
            if (length_number == 1 && number > 0 && number < 10) {
                result = unit[number];
            }
        }
        return result;
    }

    private String teth(int number) {
        //System.out.println("Викликано метод teth");
        String result = "";
        if (length_number == 2 && number >= 10 && number < 20) {
            String teth[] = {"десять", "одинадцять", "дванадцять", "тринадцять", "чотирнадцять",
                    "п'ятнадцять", "шістнадцять", "сімнадцять", "вісімнадцять", "дев'ятнадцять"};
            result = teth[number - 10];
        }
        return result;
    }

    private String decimal(int number) {
        //System.out.println("викликано метод decimal");
        String result = "";
        if (length_number == 2 && number >= 20 && number < 100) {
            String decimal[] = {"двадцять", "тридцять", "сорок", "п'ятдесят", "шістдесят", "сімдесят", "вісімдесят", "дев'яносто"};

            final int dec = number / 10;
            result = decimal[dec - 2];
            if (dec * 10 != number) {
                length_number = 1;
                result += " " + unit(number - dec * 10);
            }
        }
        if (number < 10) {
            length_number = 1;
            result = unit(number);
        }
        return result;
    }

    private String hundreds(int number) {
        //System.out.println("Викликано метод hundreads");
        String result = "";
        if (length_number == 3 && number >= 100 && number < 1000) {
            String hundreds[] = {"сто", "двісті", "триста", "чотириста", "п'ятсот", "шістсот", "сімсот", "вісімсот", "дев'ятсот"};
            final int hund = number / 100;
            result = hundreds[hund - 1];
            // System.out.println(number);
            if (hund * 100 != number) {
                if ((number - hund * 100) >= 20 && (number - hund * 100) < 100) {
                    length_number = 2;
                    result += " " + decimal(number - hund * 100);
                }
                if ((number - hund * 100) >= 10 && (number - hund * 100) < 20) {
                    length_number = 2;
                    result += " " + teth(number - hund * 100);
                }
                if ((number - hund * 100) >= 1 && (number - hund * 100) < 10) {
                    length_number = 1;
                    result += " " + unit(number - hund * 100);
                }
            }
        } else {
            System.out.println(number);
            length_number = 2;
            if ((number) >= 20 && (number) < 100) {
                length_number = 2;
                result += " " + decimal(number);
            }
            if ((number) >= 10 && (number) < 20) {
                length_number = 2;
                result += " " + teth(number);
            }
            if ((number) >= 1 && (number) < 10) {
                length_number = 1;
                result += " " + unit(number);
            }
        }
        return result;
    }

    private String thousands_4(int number) {

        String result = "";
        if (length_number == 4 && number >= 1000 && number < 10000) {
            //System.out.println("викликано метод thosands_4");
            final int thous = number / 1000;
            length_number = 1;
            result = unit(thous) + " ";
            result += addTysiach(thous) + " ";
            if (thous * 1000 != number) {
                length_number = 3;
                result += hundreds(number - thous * 1000);
            }
        }
        return result;
    }

    private String thousands_5(int number) {
        //System.out.println("викликано метод thosands_5");
        String result = "";
        if (length_number == 5 && number >= 10000 && number < 100000) {
            final int thous = number / 1000;
            length_number = 2;
            if (thous >= 10 && thous < 20) result = teth(thous) + " ";
            else result = decimal(thous) + " ";
            result += addTysiach(thous) + " ";

            if (thous * 10000 != number) {

                length_number = 3;
                result += hundreds(number - thous * 1000);
            }
        }
        return result;
    }

    private String thousands_6(int number) {
        //System.out.println("викликано метод thosands_6");
        String result = "";
        if (length_number == 6 && number >= 100000 && number < 1000000) {
            final int thous = number / 1000;
            length_number = 3;
            result = hundreds(thous) + " ";
            result += addTysiach(thous) + " ";

            if (thous * 1000 != number) {
                length_number = 3;
                result += hundreds(number - thous * 1000);
            }
        }
        return result;
    }

    private String millions(int number) {
        //System.out.println("викликано метод thosands_6");
        String result = "";
        if (length_number == 7 && number >= 1000000 && number < 10000000) {
            final int milion = number / 100000;
            length_number = 1;
            result = unit(milion) + " ";
        }
        return result;
    }

    private String Prescript() {
        String result = "";


        if (length_number == 1) {
            result = unit(number);
        } else if (number >= 10 && number < 20)
            result = teth(number);


        else if (number >= 20 && number < 100)
            result = decimal(number);

        else if (number >= 100 && number < 1000)
            result = hundreds(number);

        else if (number >= 1000 && number < 10000)
            result = thousands_4(number);

        else if (number >= 10000 && number < 100000)
            result = thousands_5(number);
        else if (number >= 100000 && number < 1000000)
            result = thousands_6(number);
        else {
            System.out.println("Число занадто велике");
        }
        return changetoUp(result);


    }

    public String allString() {
        String result = number + "-->" + Prescript() + " " + addString() + addPenny();
        System.out.print(result + "\n");
        //   return result;
        return result;
    }


    private String changeAll(String a) {
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) chars[i] = Character.toLowerCase(c);
            else if (Character.isLowerCase(c)) chars[i] = Character.toUpperCase(c);
        }
        a = new String(chars);
        return a;
    }

    private String changeAlltoUp(String a) {
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLowerCase(c)) chars[i] = Character.toUpperCase(c);
        }
        a = new String(chars);
        return a;
    }

    private String changeAlltoLow(String a) {
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) chars[i] = Character.toLowerCase(c);
        }
        a = new String(chars);
        return a;
    }

    private String changetoUp(String a) {
        char[] chars = a.toCharArray();
        char c = chars[0];
        if (Character.isLowerCase(c)) chars[0] = Character.toUpperCase(c);
        a = new String(chars);
        return a;
    }

    private String changetoLow(String a) {
        char[] chars = a.toCharArray();
        char c = chars[0];
        if (Character.isUpperCase(c)) chars[0] = Character.toLowerCase(c);
        a = new String(chars);
        return a;
    }

}
