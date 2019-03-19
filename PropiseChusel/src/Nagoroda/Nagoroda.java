/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nagoroda;

import java.util.Scanner;

/**
 * @author BUH
 */
public class Nagoroda {
    Scanner in = new Scanner(System.in);
    private int suma;

    public void setNumber(float s) {
        suma = (int) s;
    }

    public int getNumber() {
        return suma;
    }

    private int sumaAddpercent(int s) {
        int result = (int) Math.round((s * 0.27) / 100);
        return result;
    }

    private int taryf() {
        int result = 0;

        if (suma <= 20000 && suma > 0) {
            result = 650;
        } else if (suma <= 50000 && suma > 20000) {
            result = 650;
        } else if (suma <= 100000 && suma > 50000) {
            result = 850;
        } else if (suma <= 150000 && suma > 10000) {
            result = 1100;
        } else if (suma <= 200000 && suma > 150000) {
            result = 1100;
        } else if (suma <= 250000 && suma > 200000) {
            result = 1300;
        } else if (suma <= 300000 && suma > 250000) {
            result = 1300;
        } else if (suma <= 350000 && suma > 300000) {
            result = 1300;
        } else if (suma <= 400000 && suma > 350000) {
            result = 1300;
        } else if (suma <= 450000 && suma > 400000) {
            result = 1300;
        } else if (suma <= 500000 && suma > 450000) {
            result = 1300;
        } else if (suma > 500000) {
            result = 1300;
        } else {
            return -1;
        }

        return result;
    }

    private int round(int n) {
        int f = n % 10;
        if (f == 0) return n;

        switch (f) {
            case 1:
                n -= 1;
                break;
            case 2:
                n -= 2;
                break;
            case 3:
                n -= 3;
                break;
            case 4:
                n -= 4;
                break;
            case 5:
                n += 5;
                break;
            case 6:
                n += 4;
                break;
            case 7:
                n += 3;
                break;
            case 8:
                n += 2;
                break;
            case 9:
                n += 1;
                break;
        }
        return n;
    }

    private int add250() {
        if (suma == 0)
            return 0;
        return 250;
    }

    public int count() {
        int result = round(sumaAddpercent(suma) + taryf() + add250());
        //System.out.println("Результат->"+result);
        System.out.println(result);
        return 0;
    }


}
