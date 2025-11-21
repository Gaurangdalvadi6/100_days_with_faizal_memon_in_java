package six.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TerminalOperationsChallengeDemo {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Fiction", 15.99, 2018, "The Silent Garden"),
                new Book("Science", 22.50, 2020, "Cosmic Wonders"),
                new Book("Fiction", 12.75, 2005, "Echoes in the Rain"),
                new Book("Biography", 18.00, 2022, "A Life in Code"),
                new Book("Technology", 35.90, 2023, "Java Stream Mastery"),
                new Book("Fiction", 14.50, 2018, "The Midnight Library"),
                new Book("Science", 25.99, 2015, "Quantum Realm"),
                new Book("Technology", 40.00, 2023, "Advanced Spring Boot"),
                new Book("Biography", 16.99, 2019, "The Innovator's Journey"),
                new Book("Fiction", 9.99, 1998, "Old Man and the Sea")
        );

        // Total cost of all books in the bookstore
        double bookCost = books.stream()
                .mapToDouble(book -> book.price)
                .reduce(0, Double::sum);
        System.out.println(bookCost);

        // Collecting books into a list of titles
        List<String> stringList = books.stream()
                .map(t -> t.title)
                .collect(Collectors.toList());
        System.out.println(stringList);


        // Grouping books by category
        System.out.println();
        Map<String, List<Book>> stringListMap = books.stream()
                .collect(Collectors.groupingBy(Book::getCategory));
        stringListMap.forEach((category,bookList)->{
            bookList.forEach(System.out::println);
        });
    }

}


class Book {
    String title;
    double price;
    int publicationYear;
    String category;

    public Book(String title, double price, int publicationYear, String category) {
        this.title = title;
        this.price = price;
        this.publicationYear = publicationYear;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", category='" + category + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }
}
