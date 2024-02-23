import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner boby = new Scanner(System.in);

        System.out.print("Nama: ");
        String name = boby.nextLine();

        System.out.print("Jenis Kelamin (L/P): ");
        String gender = boby.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate;
        while (true) {
            try {
                System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
                String birthDateInput = boby.nextLine();
                birthDate = LocalDate.parse(birthDateInput, dateFormatter);
                break;
            } catch (Exception e) {
                System.out.println("Format tanggal salah, silakan masukkan kembali");
            }
        }

        LocalDate currentDate = LocalDate.now();
        Period agePeriod = Period.between(birthDate, currentDate);

        System.out.println("Nama: " + name);
        System.out.println("Jenis Kelamin: " + (gender.equalsIgnoreCase("L") ? "Laki-laki" : "Perempuan"));
        System.out.println("Umur Anda: " + agePeriod.getYears() + " tahun " + agePeriod.getMonths() + " bulan");
    }
}