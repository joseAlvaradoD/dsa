package jjad.dsa.string.search;

public class PaloIT {
    //metodo numero 1-3000

    public static void main(String args[]){
        System.out.println(toRomanNumber(3000));
    }

    public static String toRomanNumber(int num){
        //MMM
        //I
        String respuesta = "";
        //I
        //V
        //X
        //L
        //C
        //D
        //M

        String numStr = num+"";
        int length =numStr.length()-1;

        for(int i = length; i>=0; i--){
            int n = Integer.parseInt(numStr.charAt(i)+"");
            if(numStr.length() - i == 1){
                switch (n){
                    case 1,2,3 -> respuesta = "I".repeat(n) + respuesta;
                    case 4 -> respuesta = "IV";
                    case 5 -> respuesta = "V";
                    case 6,7,8 -> respuesta = "V"+"I".repeat(n) + respuesta;
                    case 9 -> respuesta = "IX";
                }
            } else if(numStr.length() - i == 2){
                switch (n){
                    case 1,2,3 -> respuesta = "X".repeat(n) + respuesta;
                    case 4 -> respuesta = "XL";
                    case 5 -> respuesta = "L";
                    case 6,7,8 -> respuesta = "L"+"XXX".repeat(n) + respuesta;
                    case 9 -> respuesta = "XC" + respuesta;
                }
            } else if(numStr.length() - i == 3){
                switch (n){
                    case 1,2,3 -> respuesta = "C".repeat(n) + respuesta;
                    case 4 -> respuesta = "CD";
                    case 5 -> respuesta = "D";
                    case 6,7,8 -> respuesta = "D"+"CCC".repeat(n) + respuesta;
                    case 9 -> respuesta = "CM"+ respuesta;
                }
            }else {
                respuesta = "M".repeat(n) + respuesta;
            }
            //<10
                //9
                //6-8
                //5
                //<5
                //4
                //1-3
            //<100
                //90
                //60-80
                //50
                //40
                //10-30
            //<1000
                //900
                //600-800
                //500
                //400
                //100-300
        }


        return respuesta;
    }
}
