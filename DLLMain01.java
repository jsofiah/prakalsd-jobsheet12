import  java.util.Scanner;
public class DLLMain01 {
    public static Mahasiswa01 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM\t: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama\t: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas\t: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK\t: ");
        double ipk = scan.nextDouble();
        return new Mahasiswa01(nim, nama, kelas, ipk);
    }
    public static void main(String[] args) {
        DoubleLinkedList01 list = new DoubleLinkedList01();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Tambah setelah NIM");
            System.out.println("4. Tambah pada index");
            System.out.println("5. Hapus dari awal");
            System.out.println("6. Hapus dari akhir");
            System.out.println("7. Hapus setelah NIM");
            System.out.println("8. Hapus pada index");
            System.out.println("9. Tampilkan semua data");
            System.out.println("10. Tampilkan data terdepan");
            System.out.println("11. Tampilkan data terbelakang");
            System.out.println("12. Tampilkan data pada index");
            System.out.println("13. Cari Mahasiswa berdasarkan NIM");
            System.out.println("14. Tampilkan jumlah data");
            System.out.println("15. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan){
                case 1:
                    Mahasiswa01 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                    break;
                case 2:
                    Mahasiswa01 mhs1 = inputMahasiswa(scan);
                    list.addLast(mhs1);
                    break;
                case 3:
                    System.out.print("Masukkan Key NIM: ");
                    String keyNim = scan.nextLine();
                    Mahasiswa01 mhs2 = inputMahasiswa(scan);
                    list.insertAfter(keyNim, mhs2);
                    break;
                case 4:
                    System.out.print("Masukkan index: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa01 mhs3 = inputMahasiswa(scan);
                    list.add(mhs3, index);
                    break;
                case 5:
                    list.removeFirst();
                    break;
                case 6:
                    list.removeLast();
                    break;
                case 7:
                    System.out.print("Masukkan Key NIM: ");
                    String keyNim2 = scan.nextLine();
                    list.removeAfter(keyNim2);
                    break;
                case 8:
                    System.out.print("Masukkan index: ");
                    int index2 = scan.nextInt();
                    list.remove(index2);
                    break;
                case 9:
                    list.print();
                    break;
                case 10:
                    list.getFirst();
                    break;
                case 11:
                    list.getLast();
                    break;
                case 12:
                    System.out.print("Masukkan index: ");
                    int index3 = scan.nextInt();
                    list.getIndex(index3);
                    break;
                case 13:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node01 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan: ");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 14:
                    System.out.println("Jumlah data: " + list.getSize());
                    break;
                case 15:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan !=0);
    }
}
