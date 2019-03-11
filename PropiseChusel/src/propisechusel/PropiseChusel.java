
package propisechusel;

import chuslo.Chuslo;


import java.util.Scanner;

import nagoroda.Nagoroda;

public class PropiseChusel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Chuslo numb = new Chuslo();
        Nagoroda tar = new Nagoroda();

        System.out.println(3 % 100);


        System.out.println("Оберіть розділ для роботи");
        System.out.println("1---->перевід числа в пропис");
        System.out.println("2---->Нагорода");
        System.out.println("3---->пропис тест");
        System.out.println("4---->Формат числа");
        byte unit;

        unit = in.nextByte();
        switch (unit) {
            case 1:
                for (; ; ) {
                    numb.setNumber(in.nextInt());
                    numb.allString();
                }
////////////////////////////////////////////////////////////////////////////////               
            case 2:
                for (int i = 0; i < 300; i++) {
                    tar.setNumber(in.nextInt());
                    tar.count();
                }
                break;
        }
    }
}
