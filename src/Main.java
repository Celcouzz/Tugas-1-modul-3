import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String nama;
    private double harga;
    private int jumlah;

    // Konstruktor
    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = 0;
    }

    // Setter jumlah
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Menghitung subtotal untuk item ini
    public double getSubtotal() {
        return harga * jumlah;
    }

    // Mendapatkan nama item
    public String getNama() {
        return nama;
    }

    // Mendapatkan harga item
    public double getHarga() {
        return harga;
    }

    // Mendapatkan jumlah item
    public int getJumlah() {
        return jumlah;
    }
}

class Order {
    private ArrayList<MenuItem> items;

    // Konstruktor
    public Order() {
        items = new ArrayList<>();
    }

    // Menambahkan item ke dalam pesanan
    public void tambahItem(MenuItem item) {
        items.add(item);
    }

    // Menghitung total harga pesanan
      public double getTotal() {
              double total = 0;
              for (MenuItem item : items) {
                  total += item.getSubtotal();
              }
              return total;
          }

    // Menampilkan nota pesanan
    public void printNota() {
        System.out.println("====== Nota Pesanan ======");
        for (MenuItem item : items) {
            System.out.printf("%s (x%d) - Rp %.2f\n", item.getNama(), item.getJumlah(), item.getSubtotal());
        }
        System.out.printf("Total Harga: Rp %.2f\n", getTotal());
        System.out.println("==========================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        // Daftar menu (bisa dikembangkan)
        MenuItem nasiGoreng = new MenuItem("Nasi Goreng", 15000);
        MenuItem mieGoreng = new MenuItem("Mie Goreng", 12000);
        MenuItem ayamGoreng = new MenuItem("Ayam Goreng", 18000);

        // Menambahkan item ke dalam pesanan
        System.out.print("Masukkan jumlah Nasi Goreng: ");
        nasiGoreng.setJumlah(scanner.nextInt());
        order.tambahItem(nasiGoreng);

        System.out.print("Masukkan jumlah Mie Goreng: ");
        mieGoreng.setJumlah(scanner.nextInt());
        order.tambahItem(mieGoreng);

        System.out.print("Masukkan jumlah Ayam Goreng: ");
        ayamGoreng.setJumlah(scanner.nextInt());
        order.tambahItem(ayamGoreng);

        // Menampilkan nota pesanan
        order.printNota();

        scanner.close();
    }
}
