/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini akan membuat ID keanggotaan dan mengecek validitas ID keanggotaan
*/

package assignments.assignment1;

import java.util.HashMap;
import java.util.Scanner;

public class IdGenerator {
    static HashMap<Character, Integer> charToValue = new HashMap<>(36);
    static char[] valueToChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /*
     * Code pada method main tidak boleh diganti sama sekali!
     */
    public static void main(String[] args) {
        buildMapCharToValue();
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat Datang di Perpustakaan!");

        boolean shouldTerminateProgram = false;

        while (!shouldTerminateProgram) {
            printMenu();
            System.out.print("Menu yang anda pilih: ");
            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                System.out.print("Program Studi: ");
                String programStudi = input.nextLine();
                System.out.print("Angkatan: ");
                String angkatan = input.nextLine();
                System.out.print("Tanggal Lahir: ");
                String tanggalLahir = input.nextLine();
                
                System.out.println(generateId(programStudi, angkatan, tanggalLahir));
            } else if (menu == 2) {
                System.out.print("ID Anggota: ");
                String idAnggota = input.nextLine();

                System.out.print("Validitas: ");
                System.out.println(checkValidity(idAnggota));
            } else {
                shouldTerminateProgram = true;
                System.out.println("Sampai jumpa!");
            }
        }

        input.close();
    }

    /*
     * Method buildMapCodeToNumber adalah method untuk membuat mapping reference numbers Code 93
     */
    public static void buildMapCharToValue() {
        for (int count = 0; count < valueToChar.length; count++) {
            charToValue.put(valueToChar[count], count);
        }
    }

    /*
     * Method getCharFromValue adalah method yang akan mengembalikan Code 93 dari value yang diberikan
     */
    private static char getCharFromValue(int value) {

        return valueToChar[value];
    }

    /*
     * Method getValueFromChar adalah method yang akan mengembalikan value dari Code 93 yang diberikan
     */
    private static int getValueFromChar(char character) {
        return charToValue.get(character);
    }

     /*
      * Method printMenu adalah method untuk memberi tau menu yang tersedia
      */
    private static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Menu yang tersedia:");
        System.out.println("1. Generate ID anggota untuk anggota baru");
        System.out.println("2. Check validitas ID anggota");
        System.out.println("3. Keluar");
        System.out.println("--------------------------------------------");
    }

    /*
     * Method isProgramStudi adalah method yang mereturn true
     * jika nama program studi valid
     */
    public static boolean isProgramStudi(String programStudi) {
        return (programStudi.equals("SIK")) || programStudi.equals("SSI") ||
               (programStudi.equals("MIK")) || (programStudi.equals("MTI")) ||
               (programStudi.equals("DIK"));
    }

    /*
     * Method isAngkatan adalah method yang mereturn true
     * jika tahun angkatan valid
     */
    public static boolean isAngkatan(String angkatan) {
        return (angkatan.equals("2000")) || (angkatan.equals("2001")) ||
               (angkatan.equals("2002")) || (angkatan.equals("2003")) ||
               (angkatan.equals("2004")) || (angkatan.equals("2005")) ||
               (angkatan.equals("2006")) || (angkatan.equals("2007")) ||
               (angkatan.equals("2008")) || (angkatan.equals("2009")) ||
               (angkatan.equals("2010")) || (angkatan.equals("2011")) ||
               (angkatan.equals("2012")) || (angkatan.equals("2013")) ||
               (angkatan.equals("2014")) || (angkatan.equals("2015")) ||
               (angkatan.equals("2016")) || (angkatan.equals("2017")) ||
               (angkatan.equals("2018")) || (angkatan.equals("2019")) ||
               (angkatan.equals("2020")) || (angkatan.equals("2021"));
               
    }
    /*
     * Method generateId adalah method untuk membuat ID keanggotaan perpustakaan
     */
    public static String generateId(String programStudi, String angkatan, String tanggalLahir) {       
        // Validasi input
        if ((isProgramStudi(programStudi)) && (isAngkatan(angkatan)) 
           && (tanggalLahir.length() == 10)  && ((tanggalLahir.substring(2, 3)).equals("/")) && 
           ((tanggalLahir.substring(5, 6)).equals("/")) ) {

            String idAnggota = programStudi + angkatan.substring(2) + tanggalLahir.substring(0, 2) + 
            tanggalLahir.substring(3, 5) + tanggalLahir.substring(8, 10);
            
            int sumC = 0, sumK = 0;         // Inisiasi nilai sumC dan sumK

            // Perhitungan sum “C”
            for (int i = 0, j = idAnggota.length() ; i < idAnggota.length(); i++, j--) {
                sumC += getValueFromChar(idAnggota.charAt(i)) * j;
            }
            // karakter Checksum “C”
            int checkSumC = sumC % 36;
            char charCheckSumC = getCharFromValue(checkSumC);
            idAnggota += charCheckSumC;

            // Perhitungan sum “K”
            for ( int i = 0, j = idAnggota.length() ; i < idAnggota.length(); i++, j--) {
                sumK += getValueFromChar(idAnggota.charAt(i)) * j;
            }
            
            // karakter Checksum “K”
            int checkSumK = sumK % 36;
            char charCheckSumK =  getCharFromValue(checkSumK);
            idAnggota += charCheckSumK;

            return "ID Anggota: " + idAnggota;
            
        
        }              
        return "Input tidak valid!";        
            
    }

    /*
     * Method checkValidity adalah method untuk mengecek validitas ID keanggotaan perpustakaan
     *
     */
    public static boolean checkValidity(String idAnggota) {

        // Validasi jumlah karakter
        if (idAnggota.length() == 13) {
            int count = 0 ;          // Inisiasi nilai count

            // Validasi tipe karakter
            for (int x = 0 ; x < idAnggota.length() ; x++) {
                for(int y = 0 ; y < valueToChar.length ; y++) {
                    if (idAnggota.charAt(x) == getCharFromValue(y)) {
                        count ++;
                    }
                }
            }

            // Validasi karakter  checksum "C" dan checksum “K”
            if (count == 13) {
                String idAngggotaWithoutCheckSum = idAnggota.substring(0, 11);
                int sumC = 0, sumK = 0;         // Inisiasi nilai sumC dan sumK

                // Perhitungan sum “C”
                for ( int i = 0, j = idAngggotaWithoutCheckSum.length() ; i < idAngggotaWithoutCheckSum.length(); i++, j--){ 
                    sumC += getValueFromChar(idAngggotaWithoutCheckSum.charAt(i)) * j;
                }

                // karakter Checksum “C”
                int checkSumC = sumC % 36;
                char charCheckSumC = getCharFromValue(checkSumC);
                idAngggotaWithoutCheckSum += charCheckSumC;

                // Perhitungan sum “K”
                for ( int i = 0, j = idAngggotaWithoutCheckSum.length() ; i < idAngggotaWithoutCheckSum.length(); i++ ,j--){
                    sumK += getValueFromChar(idAngggotaWithoutCheckSum.charAt(i)) * j;
                }
                
                // karakter Checksum “K”
                int checkSumK = sumK % 36;
                char charCheckSumK =  getCharFromValue(checkSumK);
                idAngggotaWithoutCheckSum += charCheckSumK;

                // ID Anggota valid
                if (idAngggotaWithoutCheckSum.equals(idAnggota)){
                    return true;
                }
            }
        }

        // iD Anggota tidak valid
        return false;       
    }
}
