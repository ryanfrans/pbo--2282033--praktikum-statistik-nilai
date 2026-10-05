import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {
    public static void main(String[] args) {

        // STEP 1 - Input dan validasi nilai
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


        // STEP 2 - Menghitung statistik dasar
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


        // STEP 3 - Grade, sorting, median dan output
        int[] grade = new int[5];

        for (int n : nilai) {
            if (n >= 85) {
                grade[0]++;
            } else if (n >= 70) {
                grade[1]++;
            } else if (n >= 60) {
                grade[2]++;
            } else if (n >= 50) {
                grade[3]++;
            } else {
                grade[4]++;
            }
        }

        ArrayList<Integer> urut = new ArrayList<>(nilai);
        Collections.sort(urut);

        double median;

        if (jumlah % 2 == 1) {
            median = urut.get(jumlah / 2);
        } else {
            median = (urut.get(jumlah / 2 - 1)
                    + urut.get(jumlah / 2)) / 2.0;
        }


        // Menampilkan hasil
        System.out.println("\n===== HASIL =====");
        System.out.println("Nilai asli       : " + nilai);
        System.out.println("Jumlah mahasiswa : " + jumlah);
        System.out.printf("Rata-rata        : %.2f%n", rata);
        System.out.println("Nilai tertinggi  : " + max);
        System.out.println("Nilai terendah   : " + min);
        System.out.println("Di atas rata-rata: " + atasRata);
        System.out.println("Grade A          : " + grade[0]);
        System.out.println("Grade B          : " + grade[1]);
        System.out.println("Grade C          : " + grade[2]);
        System.out.println("Grade D          : " + grade[3]);
        System.out.println("Grade E          : " + grade[4]);
        System.out.println("Nilai terurut    : " + urut);
        System.out.println("Median           : " + median);

        input.close();
    }
}