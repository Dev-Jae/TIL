package part2_1.ch23;

import part2_1.ch21.Book;
import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<Book> library = new ArrayList<Book>();
        library.add(new Book("태백산맥1", "추재영"));
        library.add(new Book("태백산맥2", "추재영"));
        library.add(new Book("태백산맥3", "추재영"));
        library.add(new Book("태백산맥4", "추재영"));
        library.add(new Book("태백산맥5", "추재영"));

        for(int i = 0; i < library.size(); i++){
            library.get(i).showInfo();
        }
    }
}
