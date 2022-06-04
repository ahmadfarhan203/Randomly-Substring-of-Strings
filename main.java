package com.company;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class taking_string {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []sekanslar1=new String[2];
        int secenek;

        do {
            secenek= Integer.parseInt(JOptionPane.showInputDialog("Sekanslamak icin  DNA dizilimi nasil uretmek istiyorsunuz ?\n"+
                                 "1-klayveden olusturmak icin 1 tiklayin \n2-Rastgele olusturmak icin 2 tiklayin\n3- Tabloyu gormek istereniz O basin. \nsecime girin:"));
            switch (secenek)
            {
                case 1:
                    System.out.print("klaveyden sekanslanacak DNAyi giriniz:");
                    sekanslar1=sekans_uret();
                    break;
                case 2:
                    System.out.println("rastegele sekanslar uretiliyor");
                    sekanslar1=rastgele_sekans();
                    System.out.println(sekanslar1);
            }
        }while (secenek!=0);
        new Tablo();


    }
    static String[] rastgele_sekans() {
        Scanner sc = new Scanner(System.in);
        JTextArea mc=new JTextArea(20,30);
        String[] sekanslar1 = new String[2];
        String sekans1 = "acgt";
        String str0 = "";
        int length = Integer.parseInt(JOptionPane.showInputDialog("Kac uzunluk bp uretek istiyorsnuz"));
        Random rastgele = new Random();
        char[] sk = new char[length];
        for (int i = 0; i < length; i++) {
            sk[i] = sekans1.charAt(rastgele.nextInt(sekans1.length()));
        }
        for (int i = 0; i < sk.length; i++) {
            str0 += sk[i];
        }
        System.out.println("rastgele sekans : " + str0 + "\n");

        //reversing
        String jv = str0;
        int leng = jv.length();
        String rev = "";
        for (int f = leng - 1; f >= 0; f--) {
            System.out.print("Reversed DNA DIZIMi: "+jv.charAt(f)); //reversed
        }
        //System.out.println("\n");
        //N ve L cikartma
        int wordCount = Integer.parseInt(JOptionPane.showInputDialog(" Comlement Sekansin uzunlugunu(L sayisi)giriniz"));
        int totalSubstring =Integer.parseInt(JOptionPane.showInputDialog(" Comlement Sekans istedigini(N sayisi)giriniz."));
        StringBuilder cs = new StringBuilder();
        for (int i = 0; i < totalSubstring; i++) {
            for (int j = 0; j < wordCount; j++) {
                int index = (int) (wordCount * Math.random());
                cs.append(str0.charAt(index));
            }
            cs.append("\n");
        }
        mc.setText(" Rastegele Yuretilmis DNA dizilmin  Comlementi\n"+cs);
        JOptionPane.showMessageDialog(null,mc);
        cs.setLength(0);

            // tersten
        int wc = Integer.parseInt(JOptionPane.showInputDialog("Reverse Complimentin Sekansin uzunlugunu(L sayisi)giriniz"));
        int ff =Integer.parseInt(JOptionPane.showInputDialog(" Reverse Complimentin Sekans istedigini(N sayisi)giriniz."));
        StringBuilder ks = new StringBuilder();
            for (int m = 0; m < ff; m++) {
                for (int n = 0; n < wc; n++) {
                    int index = (int) (wc * Math.random());
                    ks.append(jv.charAt(index));
                }
                ks.append("\n");
            }
        mc.setText("Rastegele Uretilmis DNA Dizlimin Reverse Complementi okunan sekanslar \n"+ks);
        JOptionPane.showMessageDialog(null,mc);
        ks.setLength(0);


            return sekanslar1;
    }
    static String[] sekans_uret(){
        Scanner sc = new Scanner(System.in);
        JTextArea mc=new JTextArea(20,30);
        String []sekanslar1=new String[2];
        String str = JOptionPane.showInputDialog("Lutfen sekanslanacak DNA dizilmi girniz:");
       // System.out.println("girlimis sekans: " + str);
        String jv=str;
        int leng=jv.length();
        String rev="";
        for(int f=leng-1;f>=0;f--)
        {
            System.out.print(jv.charAt(f)); //reversed
        }
        System.out.println("\n");

        boolean isValid = isValidString(str);
        if(isValid) {
            int wordCount = Integer.parseInt(JOptionPane.showInputDialog("Girikmis DNA dizilimin Complement sekansin uzunlugunu(L sayisi)giriniz"));
            int totalSubstring =Integer.parseInt(JOptionPane.showInputDialog("Girikmis DNA dizilimin Complement sekans istedigini(N sayisi)giriniz."));
            boolean validLength = isValidLength(str, wordCount, totalSubstring);

            if(validLength) {
                StringBuilder sb = new StringBuilder();
                for(int i= 0; i< totalSubstring; i++) {
                    for(int j=0; j<wordCount; j++) {
                        int index= (int) (wordCount* Math.random());
                        sb.append(str.charAt(index));

                    }
                    sb.append("\n");

                }
                mc.setText("Girikmis DNA dizilimin Complement\n"+sb);
                JOptionPane.showMessageDialog(null,mc);
                sb.setLength(0);
                // tersten
                int wc = Integer.parseInt(JOptionPane.showInputDialog("Girikmis DNA dizilimin reverse Complement sekansin uzunlugunu(L sayisi)giriniz"));
                int ff =Integer.parseInt(JOptionPane.showInputDialog("Girikmis DNA dizilimin reverse Complement sekans istedigini(N sayisi)giriniz."));
                StringBuilder ks = new StringBuilder();
                for (int m = 0; m < ff; m++) {
                    for (int n = 0; n < wc; n++) {
                        int index = (int) (wc * Math.random());
                        ks.append(jv.charAt(index));
                    }
                    ks.append("\n");
                }
                mc.setText("Girikmis DNA dizilimin Complementi \n"+ks);
                JOptionPane.showMessageDialog(null,mc);
                ks.setLength(0);
            }
        }
        return sekanslar1;
    }

    public static boolean isValidString(String str) {

        if (str.length() < 1) {
            System.out.println("Length of string should be more than zero.");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            Character myChar = str.charAt(i);
            if (myChar == 'a' || myChar == 'c' || myChar == 'g' || myChar == 't') {

            } else {
                System.out.println("String should be a combination of only alphabets 'a' or 'c' or 'g' or 't' ");
                return false;
            }
        }
        return true;
    }

    public static boolean isValidLength(String str, int sekans_uret, int totalSubstring) {

        if(sekans_uret > str.length()) {
            System.out.println("uzunlugu DNA dizliminden az olmali.");
            return false;
        }
        if(totalSubstring > str.length()) {
            System.out.println("N saysi DNA diziminden az olmali.");
            return false;
        }
        return true;
    }
    static class Tablo extends JFrame {

        public Tablo() {
            JFrame f = new JFrame("Farhan Ahmad . 20360859096");
            JTable jt = new JTable();
            JScrollPane sp = new JScrollPane(jt);
            JPanel jpnl=new JPanel();
            JLabel jlb=new JLabel();
            JLabel jlb2=new JLabel();
            jpnl.setBounds(10, 20, 1200, 700);
            jpnl.setLayout(null);
            this.add(jpnl);
            jlb.setBounds(20,0,1200,18);
            jpnl.add(jlb);
            jlb2.setBounds(20,20,500,18);
            jpnl.add(jlb2);

            //jt.setBounds(50, 50, 100, 100);



           // DefaultTableModel model;
           // model = new DefaultTableModel();
           // add(new JScrollPane(jt));
            int n=20;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        JLabel etiket=new JLabel("*");
                        etiket.setBounds(i*10, j*10, 10, 10);
                        f.setSize(1280,720);
                        f.add(etiket);
                        f.add(sp);
                        f.setResizable(true);
                        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f.setVisible(true);
                        continue;
                    }
                }
            }
        }
    }
}

