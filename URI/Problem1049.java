import java.util.*;
import java.lang.Math;
import java.util.Scanner;

public class Problem1049 {
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s;
        
        s = input.nextLine();
        if (s.equals("vertebrado")) {
            s = input.nextLine();
            if (s.equals("ave")) {
                s = input.nextLine();
                if (s.equals("carnivoro")) {
                    System.out.println("aguia");
                } else {
                    if (s.equals("onivoro")) {
                        System.out.println("pomba");
                    }
                }
            } else {
                if (s.equals("mamifero")) {
                    s = input.nextLine();
                    if (s.equals("onivoro")) {
                        System.out.println("homem");
                    } else {
                        if (s.equals("herbivoro")) {
                            System.out.println("vaca");
                        }
                    }
                }
            }
        } else {
            if (s.equals("invertebrado")) {
                s = input.nextLine();
                if (s.equals("inseto")) {
                    s = input.nextLine();
                    if (s.equals("hematofago")) {
                        System.out.println("pulga");
                    } else {
                        if (s.equals("herbivoro")) {
                            System.out.println("lagarta");
                        }
                    }
                } else {
                    if (s.equals("anelideo")) {
                        s = input.nextLine();
                        if (s.equals("hematofago")) {
                            System.out.println("sanguessuga");
                        } else {
                            if (s.equals("onivoro")) {
                                System.out.println("minhoca");
                            }
                        }
                    }
                }
            }
        }
    }
}