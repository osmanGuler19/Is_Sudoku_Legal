package com.company;
import java.util.*;
import java.io.*;

class Main {

    // n1 -> satir , n2 -> sutun
    public static int findSubGrid(int n1, int n2){
        if(n1<=2){
            if(n2<=2) return 1;
            else if(n2<=5) return 2;
            else return 3;
        }
        else if(n1<=5){
            if(n2<=2) return 4;
            else if(n2<=5) return 5;
            else return 6;
        }
        else{
            if(n2<=2) return 7;
            else if(n2<=5) return 8;
            else return 9;
        }
    }

    public static String SudokuQuadrantChecker(String[] strArr) {
        // code goes here
        for(int i=0;i<strArr.length;i++){
            strArr[i] = strArr[i].replaceAll("\\(","").replaceAll("\\)","");
            strArr[i] = strArr[i].replaceAll(",","");
            //System.out.println(strArr[i]);
        }
        List<Integer> subGrids = new ArrayList<Integer>();

        for(int i=0;i<strArr.length;i++){
            for(int j=0;j<strArr[i].length();j++){
                if(strArr[i].charAt(j)=='x') continue;
                int current = Character.getNumericValue(strArr[i].charAt(j));

                //Satir Aramasi
                for(int k=0; k<strArr[i].length();k++){
                    if(k==j) continue;
                    if(Character.getNumericValue(strArr[i].charAt(k))==current){
                        int t= findSubGrid(i,k);
                        if(!subGrids.contains(t)) subGrids.add(t);
                        //Ayni zamanda kendisin oldugu subgrid de eklenmeli
                        //System.out.println(t);
                        int t2 = findSubGrid(i,j);
                        if(!subGrids.contains(t2)) subGrids.add(t2);
                    }
                }
                //Sutun
                for(int l=0;l<strArr.length;l++){
                    if(l==i) continue;
                    if(Character.getNumericValue(strArr[l].charAt(j))==current){
                        int t = findSubGrid(l,j);
                        if(!subGrids.contains(t)) subGrids.add(t);
                        //Ayni zamanda kendisin oldugu subgrid de eklenmeli
                        //System.out.println(t);
                        int t2 = findSubGrid(i,j);
                        if(!subGrids.contains(t2)) subGrids.add(t2);

                    }
                }
                //sub-grid aramasi
                int s = findSubGrid(i,j);
                String sub = "";
                if(s==1){
                    for(int a=0;a<=2;a++){
                        for(int b=0;b<=2;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==2){
                    for(int a=0;a<=2;a++){
                        for(int b=3;b<=5;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==3){
                    for(int a=0;a<=2;a++){
                        for(int b=6;b<=8;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==4){
                    for(int a=3;a<=5;a++){
                        for(int b=0;b<=2;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==5){
                    for(int a=3;a<=5;a++){
                        for(int b=3;b<=5;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==6){
                    for(int a=3;a<=5;a++){
                        for(int b=6;b<=8;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==7){
                    for(int a=6;a<=8;a++){
                        for(int b=0;b<=2;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==8){
                    for(int a=6;a<=8;a++){
                        for(int b=3;b<=5;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }
                else if(s==7){
                    for(int a=6;a<=8;a++){
                        for(int b=6;b<=8;b++){
                            //Kendisini eklersek hep buluruz. O yuzden eklemiyoruz
                            if(a==i && b==j) continue;
                            sub+=strArr[a].charAt(b);
                        }
                    }
                }

                if(sub.contains(String.valueOf(strArr[i].charAt(j))) ) {
                    if(!subGrids.contains(s)) subGrids.add(s);
                }

            }
        }
        Collections.sort(subGrids);
        if(subGrids.isEmpty()){
            return "legal";
        }
        else{
            String returnS = "";
            for(int i=0;i<subGrids.size();i++){
                if(i!= subGrids.size()-1){
                    returnS = returnS+ subGrids.get(i)+",";
                }
                else returnS+=subGrids.get(i);
            }
            return returnS;
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SudokuQuadrantChecker(s.nextLine()));
    }

}