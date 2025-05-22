package dll;

import java.util.Scanner;
public class DLLMain24 {

    public static void main(String[] args) {
        DoubleLinkedList24 list = new DoubleLinkedList24();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Sisipkan setelah NIM tertentu");
            System.out.println("8. Tampilkan jumlah data");
            System.out.println("9. Tampilkan data pada node pertama");
            System.out.println("10. Tampilkan data pada node terakhir");
            System.out.println("11. Tampilkan data pada indeks tertentu");
            System.out.println("12. Tambah data pada indeks tertentu");
            System.out.println("13. Hapus data setelah NIM tertentu");
            System.out.println("14. Hapus data pada indeks tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1: {
                    Mahasiswa24 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                    break;
                }
                case 2: {
                    Mahasiswa24 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                    break;
                }
                case 3:
                    list.removeFirst();
                    break;
                case 4:
                    list.removeLast();
                    break;
                case 5:
                    list.print();
                    break;
                case 6: {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node24 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan:");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                }
                case 7: {
                    System.out.print("Masukkan NIM setelah mana data akan disisipkan: ");
                    String keyNim = scan.nextLine();
                    Mahasiswa24 mhs = inputMahasiswa(scan);
                    list.insertAfter(keyNim, mhs);
                    break;
                }
                case 8:
                    System.out.println("Jumlah data saat ini: " + list.size());
                    break;
                case 9:
                    list.getFirst();
                    break;
                case 10:
                    list.getLast();
                    break;
                case 11:
                    System.out.print("Masukkan indeks yang ingin ditampilkan: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    list.getIndex(idx);
                    break;
                case 12:
                    System.out.println("Masukkan indeks yang ingin disisipkan:");
                    int indeksTambah = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nimTambah = scan.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String namaTambah = scan.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelasTambah = scan.nextLine();
                    System.out.print("Masukkan IPK: ");
                    double ipkTambah = scan.nextDouble();
                    scan.nextLine();
                    Mahasiswa24 mhsTambah = new Mahasiswa24(nimTambah, namaTambah, kelasTambah, ipkTambah);
                    list.add(indeksTambah, mhsTambah);
                    break;
                case 13:
                    System.out.print("Masukkan NIM acuan: ");
                    String nimAcuan = scan.nextLine();
                    list.removeAfter(nimAcuan);
                    break;
                case 14: {
                    System.out.print("Masukkan indeks yang ingin dihapus: ");
                    int indeksHapus = scan.nextInt();
                    scan.nextLine();
                    list.remove(indeksHapus);
                    break;
                }
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 0);

        scan.close();
    }

    public static Mahasiswa24 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa24(nim, nama, kelas, ipk);
    }
}