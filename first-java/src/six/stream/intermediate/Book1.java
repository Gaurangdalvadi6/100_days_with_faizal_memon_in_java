package six.stream.intermediate;

public class Book1 {
    String title;
    String publicationYear;
    double price;
    String category;

    public Book1() {
    }

    public Book1(String title, String publicationYear, double price, String category) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book1{" +
                "title='" + title + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
