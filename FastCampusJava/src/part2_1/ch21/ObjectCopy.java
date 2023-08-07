package part2_1.ch21;

public class ObjectCopy {
    public static void main(String[] args) {
        Book[] library = new Book[5];
        Book[] copyLibrary = new Book[5];

        library[0] = new Book("태백산맥1", "추재영");
        library[1] = new Book("태백산맥2", "추재영");
        library[2] = new Book("태백산맥3", "추재영");
        library[3] = new Book("태백산맥4", "추재영");
        library[4] = new Book("태백산맥5", "추재영");

        copyLibrary[0] = new Book();
        copyLibrary[1] = new Book();
        copyLibrary[2] = new Book();
        copyLibrary[3] = new Book();
        copyLibrary[4] = new Book();

        for(int i = 0; i < library.length; i++){
            copyLibrary[i].setAutor(library[i].getAutor());
            copyLibrary[i].setTitle(library[i].getTitle());
        }

        // arrayCopy를 이용하여 복사시, 기존 객체의 주소도 복사되어 기존 객체를 수정하면 복사된 객체도 수정됨
        //System.arraycopy(library, 0, copyLibrary, 0, 5);

        library[0].setAutor("남현영");
        library[0].setTitle("북유럽신화");

        System.out.println("== library ==");
        for(Book book : library){
            System.out.println(book);
            book.showInfo();
        }

        System.out.println("== copyLibrary ==");
        for(Book book : copyLibrary){
            System.out.println(book);
            book.showInfo();
        }
    }
}
