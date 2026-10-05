import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> nilai = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");

        int no = 1;

        while (true) {
            System.out.print("Nilai ke-" + no + " : ");
            int n = input.nextInt();

            if (n == -1) {
                break;
            }

            if (n < 0 || n > 100) {
                System.out.println("Ditolak, nilai harus 0-100");
                continue;
            }

            nilai.add(n);
            no++;
        }

        if (nilai.size() == 0) {
            System.out.println("Tidak ada nilai.");
            return;
        }

        int jumlah = nilai.size();
        int total = 0;

        for (int n : nilai) {
            total += n;
        }

        double rata = (double) total / jumlah;

        int max = nilai.get(0);
        int min = nilai.get(0);

        for (int n : nilai) {
            if (n > max) {
                max = n;
            }

            if (n < min) {
                min = n;
            }
        }

        int atasRata = 0;

        for (int n : nilai) {
            if (n > rata) {
                atasRata++;
            }
        }
    }
}