import java.sql.*;
import java.util.Scanner;

public class Main {
    //Koneksi ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_siswa";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        //Menampilkan menu
        showMenu();
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nAplikasi CRUD Data Siswa");
            System.out.println("1. Tampilkan Data Siswa");
            System.out.println("2. Tambah Data Siswa");
            System.out.println("3. Edit Data Siswa");
            System.out.println("4. Hapus Data Siswa");
            System.out.println("5. Keluar");
            System.out.print("Pilihan : ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    showAll();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silahkan masukkan pilihan kembali!");
                    break;
            }
        } while (pilihan != 5);
    }

    public static void showAll() {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT nim, nama FROM siswa";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
            }
            

          
