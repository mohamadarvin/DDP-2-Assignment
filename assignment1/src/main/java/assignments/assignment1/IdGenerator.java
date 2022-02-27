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
        for (int i = 2000 ; i < 2022 ; i++){
            String tahunAngkatanValid = "" + i;
            if(angkatan.equals(tahunAngkatanValid)) {
                return true;
            }
        }
        return false;
               
    }

    /*
     * Method checkSumC adalah method untuk menggabungkan
     * Nilai Checksum "C" dengan ID keanggotaan
     */
    public static String checkSumC(String idAngggotaWithoutCheckSumC) {
        // Inisiasi nilai sumC
        int sumC = 0;           

        // Perhitungan sum “C”
        for (int i = 0, j = idAngggotaWithoutCheckSumC.length() ; i < idAngggotaWithoutCheckSumC.length(); i++, j--) {
            sumC += getValueFromChar(idAngggotaWithoutCheckSumC.charAt(i)) * j;
        }

        // ID keanggotaan dengan Checksum “C”
        return idAngggotaWithoutCheckSumC + getCharFromValue(sumC % 36);
    }

    /*
     * Method checkSumC adalah method untuk menggabungkan
     * Nilai Checksum "k" dengan ID keanggotaan
     */
    public static String checkSumK(String idAngggotaWithoutCheckSumK) {

        // Inisiasi nilai sumK
        int sumK = 0;           
        
        // Perhitungan sum “K”
        for ( int i = 0, j = idAngggotaWithoutCheckSumK.length() ; i < idAngggotaWithoutCheckSumK.length(); i++, j--) {
            sumK += getValueFromChar(idAngggotaWithoutCheckSumK.charAt(i)) * j;
        }

        // ID keanggotaan dengan Checksum “K”
        return idAngggotaWithoutCheckSumK + getCharFromValue(sumK % 36);
    }

    /*
     * Method jumlahKarakterYangSesuaiKode93 adalah method untuk menghtung
     * jumlah karakter yang sesuai dengan Code 93
     */
    public static int jumlahKarakterYangSesuaiKode93(String idAnggota) {

        // Inisiasi nilai count
        int count = 0 ;          

        // Validasi tiap karakter ID keanggotaan
        for (int x = 0 ; x < idAnggota.length() ; x++) {
            for(int y = 0 ; y < valueToChar.length ; y++) {
                if (idAnggota.charAt(x) == getCharFromValue(y)) {
                    count ++;
                }
            }
        }
        
        // Total karakter yang valid
        return count;        
    }



    /*
     * Method generateId adalah method untuk membuat ID keanggotaan perpustakaan
     */
    public static String generateId(String programStudi, String angkatan, String tanggalLahir) { 

        // Validasi input
        if ((isProgramStudi(programStudi)) && (isAngkatan(angkatan)) 
           && (tanggalLahir.length() == 10)  && ((tanggalLahir.substring(2, 3)).equals("/")) && 
           ((tanggalLahir.substring(5, 6)).equals("/")) ) {

            // ID keanggotaan tanpa Checksum
            String idAngggotaWithoutCheckSum = programStudi + angkatan.substring(2) + tanggalLahir.substring(0, 2) + 
            tanggalLahir.substring(3, 5) + tanggalLahir.substring(8, 10);            
            
            // ID keanggotaan dengan Checksum “C” dan Checksum “K”
            return "ID Anggota: " + checkSumK(checkSumC(idAngggotaWithoutCheckSum));
            
        
        }              
        return "Input tidak valid!";        
            
    }

    /*
     * Method checkValidity adalah method untuk mengecek validitas ID keanggotaan perpustakaan
     *
     */
    public static boolean checkValidity(String idAnggota) {

        // Validasi checksum "C" dan checksum “K” pada ID keanggotaan
        if (jumlahKarakterYangSesuaiKode93(idAnggota) == 13) {
            String idAngggotaWithoutCheckSum = idAnggota.substring(0, 11);            

            // ID Anggota valid
            if (checkSumK(checkSumC(idAngggotaWithoutCheckSum)).equals(idAnggota)){
                return true;
            }
            }
        

        // iD Anggota tidak valid
        return false;       
    }
}
