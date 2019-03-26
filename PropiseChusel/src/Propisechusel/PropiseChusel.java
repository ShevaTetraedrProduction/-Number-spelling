
package Propisechusel;

import Chuslo.Chuslo;
import Count.Count;


import java.util.Scanner;

import Nagoroda.Nagoroda;


public class PropiseChusel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Chuslo numb = new Chuslo();
        Nagoroda nag = new Nagoroda();
        Count count = new Count();

        System.out.println(3 % 100);


        System.out.println("Оберіть розділ для роботи");
        System.out.println("1---->перевід числа в пропис");
        System.out.println("2---->Кількість штук");
        System.out.println("3---->Нагорода");
        byte unit;

        unit = in.nextByte();
        switch (unit) {
            case 1:
                /*
                240 000-wrong

                 */
                for (; ; ) {
                    numb.setNumber((int) in.nextDouble());
                    numb.allString();
                }
////////////////////////////////////////////////////////////////////////////////               
            case 2:
                for (int i = 0; i < 300; i++) {
                    count.setNumber((int) in.nextDouble());
                    count.start();
                }

                break;

            case 3:
                for (int i = 0; i < 300; i++) {
                    nag.setNumber((int) in.nextDouble());
                    nag.count();
                }
                break;
        }
    }
}
