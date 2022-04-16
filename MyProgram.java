import java.util.Scanner;
public class MyProgram {
    static char[][] table= new char[5][5];
    static void createTable() {
        for(int i=0; i<2; i++)
            for(int j=0; j<5; j++) {
                if(i*5+j+65!=74)
                    table[i][j]=(char)(i*5+j+65);
            }table[1][4]='K';
        for(int i=2;i<5;i++)
            for(int j=0;j<5;j++)
                table[i][j]=(char)(i*5+j+65+1);

    }
    static String encrypt(String pt) {
        String encpt= "";
        char[] encpt1= pt.toCharArray();
        for(int i=0; i<pt.length(); i++) {
            for(int j=0; j<5; j++)
                for(int k=0; k<5; k++) {
                    if(encpt1[i]=='J') {
                        encpt=encpt+"24";break;

                    }if(table[j][k]==encpt1[i]) {
                        encpt=encpt+Integer.toString(j+1)+Integer.toString(k+1);
                        break;

                    }

                }

        }return encpt;

    }
    static String decrypt(String encpt) {
        String decpt="";
        char[] decpt1= encpt.toCharArray();
        for(int i=0; i<encpt.length(); i=i+2) {
            int row= Integer.parseInt(String.valueOf(decpt1[i]));
            int col= Integer.parseInt(String.valueOf(decpt1[i+1]));
            decpt=decpt+Character.toString(table[row-1][col-1]);

        }
        return decpt;

    }public static void main(String[] args) {
        String pt,encpt,decpt;
        System.out.print("Shkruaj plaintextin: ");
        Scanner scanner= new Scanner(System.in);
        pt= scanner.nextLine();
        createTable();
        encpt= encrypt(pt);
        System.out.println("Teksti i enkriptuar: "+encpt);
        decpt= decrypt(encpt);
        System.out.println("Teksti i dekriptuar: "+decpt);

    }

}