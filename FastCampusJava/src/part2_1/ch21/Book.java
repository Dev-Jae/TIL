package part2_1.ch21;

public class Book {


    private String title;
    private String autor;

    public Book(){}
    public Book(String title, String autor){
        this.title = title;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void showInfo(){
        System.out.println(title + ", " + autor);
    }

}
