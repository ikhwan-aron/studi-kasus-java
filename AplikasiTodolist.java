import java.util.Scanner;

public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();

    }

//    menampilkan todo list
    public static void showTodolist() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null ) {
                System.out.println(no + ". " + todo );
            }
        }
    }

    public static void testshowTodolist() {
        model[0] = "belajar java dasar";
        model[1] = "belajar java oop";
        model[2] = "belajar java unit test";
        showTodolist();
    }

//    menambah todo ke list
    public static void addTodolist(String todo) {
//      cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
//             model masih ada yang kosong
               isFull = false;
               break;
            }
        }

//      jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            var temp= model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
//      tambahkan ke posisi yang data arraynya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodolist() {
        for (int i = 0; i < 25; i++) {
            addTodolist("contoh todo ke i " + i);
        }

        showTodolist();
    }

//    menghapus todo dari list
    public static boolean removeTodolist(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static void testRemoveTodolist() {
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        addTodolist("empat");
        addTodolist("lima");

        var result = removeTodolist(30);
        System.out.println(result);

        result = removeTodolist(7);
        System.out.println(result);

        result = removeTodolist(2);
        System.out.println(result);

        showTodolist();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name= input("Nama anda");
        System.out.println("Hi " + name);
    }

//    menampilkan view show todolist
    public static void viewShowTodoList() {
        while (true) {
            showTodolist();

            System.out.println("MENU");
            System.out.println("[1] Tambah");
            System.out.println("[2] Hapus");
            System.out.println("[3] Keluar");

            var input = input("PILIH");

            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("pilihan tidak ada!!");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        addTodolist("empat");
        addTodolist("lima");
        viewShowTodoList();
    }


//    menampilkan view menambahkan todo list
    public static void viewAddTodolist() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (tekan x jika batal)");

        if (todo.equals("x")) {
            //batal
        }else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodolist("satu");
        addTodolist("dua");
        viewAddTodolist();

        showTodolist();
    }

    //    menampilkan view menghapus todolist
    public static void viewRemoveTodolist() {
        System.out.println("MENGAHPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")) {
            //batal
        }else {
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        showTodolist();

        viewRemoveTodolist();

        showTodolist();
    }
}
