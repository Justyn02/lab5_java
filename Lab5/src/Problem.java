import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Item {
    int wartosc;
    int waga;
    int id;

    public Item(int wartosc, int waga, int id) {
        this.wartosc = wartosc;
        this.waga = waga;
        this.id = id;
    }
}

class Result {
    List<Integer> listaPrzedmiotow;
    int iloscPrzedmiotow;
    int totalwartosc;
    int totalwaga;

    public Result(List<Integer> listaPrzedmiotow, int iloscPrzedmiotow, int totalwartosc, int totalwaga) {
        this.listaPrzedmiotow = listaPrzedmiotow;
        this.iloscPrzedmiotow = iloscPrzedmiotow;
        this.totalwartosc = totalwartosc;
        this.totalwaga = totalwaga;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Result:\n");
        stringBuilder.append("Items: ").append(listaPrzedmiotow).append("\n");
        stringBuilder.append("Number of items: ").append(iloscPrzedmiotow).append("\n");
        stringBuilder.append("Total wartosc: ").append(totalwartosc).append("\n");
        stringBuilder.append("Total waga: ").append(totalwaga).append("\n");
        return stringBuilder.toString();
    }
}

    public class Problem {
        private int LiczbaPrzedmiotow;
        private long seed;
        private int dolGranica;
        private int goraGranica;
        public List<Item> itemList;

        public Problem(int LiczbaPrzedmiotow, long seed, int dolGranica, int goraGranica) {
            this.LiczbaPrzedmiotow = LiczbaPrzedmiotow;
            this.seed = seed;
            this.dolGranica = dolGranica;
            this.goraGranica = goraGranica;
            this.itemList = new ArrayList<>();
            Generuj();
        }

        public void Generuj() {
            Random random = new Random(seed);
            for (int i = 0; i < LiczbaPrzedmiotow; i++) {
                int wartosc = random.nextInt(goraGranica - dolGranica + 1) + dolGranica;
                int waga = random.nextInt(goraGranica - dolGranica + 1) + dolGranica;
                int id = i;
                itemList.add(new Item(wartosc, waga, id));
            }
        }

        public Result solve(int capacity) {
            Collections.sort(itemList, (a, b) -> Double.compare((double) b.wartosc / b.waga, (double) a.wartosc / a.waga));

            List<Integer> wybranePrzedmioty = new ArrayList<>();
            int totalwartosc = 0;
            int totalwaga = 0;

            for (Item item : itemList) {
                while (totalwaga + item.waga <= capacity) {
                    wybranePrzedmioty.add(item.id);
                    totalwartosc += item.wartosc;
                    totalwaga += item.waga;
                }
            }

            return new Result(wybranePrzedmioty, wybranePrzedmioty.size(), totalwartosc, totalwaga);
        }

        @Override
        public String toString() {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Problem with ").append(LiczbaPrzedmiotow).append(" items:\n");
            for (int i = 0; i < LiczbaPrzedmiotow; i++) {
                stringBuilder.append("Item ").append(i).append(": wartosc=").append(itemList.get(i).wartosc)
                        .append(", waga=").append(itemList.get(i).waga).append("\n");
            }
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            Problem problem = new Problem(5, 1977, 1, 10);
            System.out.println(problem);

            int capacity = 17;
            Result result = problem.solve(capacity);
            System.out.println(result);
        }
    }


//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
//class Item {
//    int wartosc;
//    int waga;
//    int id;
//
//    public Item(int wartosc, int waga, int id) {
//        this.wartosc = wartosc;
//        this.waga = waga;
//        this.id=id;
//    }
//}
//
//class Result {
//    List<Integer> listaPrzedmiotow;
//    int iloscPrzedmiotow;
//    int totalwartosc;
//    int totalwaga;
//
//    public Result(List<Integer> listaPrzedmiotow, int iloscPrzedmiotow, int totalwartosc, int totalwaga) {
//        this.listaPrzedmiotow = listaPrzedmiotow;
//        this.iloscPrzedmiotow = iloscPrzedmiotow;
//        this.totalwartosc = totalwartosc;
//        this.totalwaga = totalwaga;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Result:\n");
//        stringBuilder.append("Items: ").append(listaPrzedmiotow).append("\n");
//        stringBuilder.append("Number of items: ").append(iloscPrzedmiotow).append("\n");
//        stringBuilder.append("Total wartosc: ").append(totalwartosc).append("\n");
//        stringBuilder.append("Total waga: ").append(totalwaga).append("\n");
//        return stringBuilder.toString();
//    }
//}
//
//public class Problem {
//    private int LiczbaPrzedmiotow;
//    private long seed;
//    private int dolGranica;
//    private int goraGranica;
//    private List<Item> itemList;
//
//    public Problem(int LiczbaPrzedmiotow, long seed, int dolGranica, int goraGranica) {
//        this.LiczbaPrzedmiotow = LiczbaPrzedmiotow;
//        this.seed = seed;
//        this.dolGranica = dolGranica;
//        this.goraGranica = goraGranica;
//        this.itemList = new ArrayList<>();
//        Generuj();
//    }
//
//    public void Generuj() {
//        Random random = new Random(seed);
//        for (int i = 0; i < LiczbaPrzedmiotow; i++) {
//            int wartosc = random.nextInt(goraGranica - dolGranica + 1) + dolGranica;
//            int waga = random.nextInt(goraGranica - dolGranica + 1) + dolGranica;
//            int id=i;
//            itemList.add(new Item(wartosc, waga, id));
//        }
//    }
//    public Result solve(int capacity) {
//        Collections.sort(itemList, (a, b) -> Double.compare((double)b.wartosc / b.waga, (double)a.wartosc / a.waga));
//
//        List<Integer> wybranePrzedmioty = new ArrayList<>();
//        int totalwartosc = 0;
//        int totalwaga = 0;
//
//        for (Item item : itemList) {
//            while (totalwaga + item.waga <= capacity) {
//                wybranePrzedmioty.add(item.id);
//                totalwartosc += item.wartosc;
//                totalwaga += item.waga;
//            }
//        }
//
//        return new Result(wybranePrzedmioty, wybranePrzedmioty.size(), totalwartosc, totalwaga);
//    }
//
//
//    //    public Result solve(int capacity) {
////        Collections.sort(itemList, (a, b) -> Double.compare((double)b.wartosc / b.waga, (double)a.wartosc / a.waga));
////
////        List<Integer> wybranePrzedmioty = new ArrayList<>();
////        int totalwartosc = 0;
////        int totalwaga = 0;
////
////        for (Item item : itemList) {
////            while (totalwaga + item.waga <= capacity) {
////                wybranePrzedmioty.add(item.id);
////                totalwartosc += item.wartosc;
////                totalwaga += item.waga;
////            }
////        }
////
////        return new Result(wybranePrzedmioty, wybranePrzedmioty.size(), totalwartosc, totalwaga);
////    }
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Problem with ").append(LiczbaPrzedmiotow).append(" items:\n");
//        for (int i = 0; i < LiczbaPrzedmiotow; i++) {
//            stringBuilder.append("Item ").append(i).append(": wartosc=").append(itemList.get(i).wartosc)
//                    .append(", waga=").append(itemList.get(i).waga).append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    public static void main(String[] args) {
//        // Example usage
//        Problem problem = new Problem(5, 1977, 1, 10);
//        System.out.println(problem);
//
//        int capacity = 17;
//        Result result = problem.solve(capacity);
//        System.out.println(result);
//    }
//}
