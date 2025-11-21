package six.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateDemo {

    public static void main(String[] args) {
        List<Book1> Book1s = Arrays.asList(
                new Book1("The Art of Thinking Clearly", "2023", 16.00, "Self Help"),
                new Book1("King of Envy", "2024", 22.00, "Fiction"),
                new Book1("The Psychology Of Money", "2022", 31.00, "Finance"),
                new Book1("I Fell in Love with Hope", "2023", 27.00, "Romance"),
                new Book1("The Nightingale", "2023", 21.00, "Historical Fiction"),
                new Book1("Rich Dad Poor Dad", "2021", 42.00, "Finance"),
                new Book1("Think Like A Monk", "2023", 13.00, "Self Help"),
                new Book1("Deep Work", "2023", 49.00, "Productivity"),
                new Book1("Mindset", "2022", 88.00, "Psychology"),
                new Book1("The Compound Effect", "2022", 30.00, "Self Improvement")
        );

        // 1. Filtering: Book1s cheaper than $20
        Book1s.stream()
                .filter(p -> p.price < 20)
                .forEach(System.out::println);

        System.out.println();
        // 2. Mapping: Convert Book1 titles to uppercase
        Book1s.stream()
                .map(u -> u.title.toUpperCase())
                .forEach(System.out::println);

        System.out.println();
        // 3. Sorting: Book1s by publication date
        Stream<Book1> sortedBook1ByYear = Book1s.stream()
                .sorted(Comparator.comparing(s -> s.publicationYear));
        sortedBook1ByYear.forEach(System.out::println);

        System.out.println();
        // 4. Distinct: Remove duplicate titles
        // Not Work checked by me
        Stream<Book1> distinctBook1Stream = Book1s.stream()
                .distinct();
        distinctBook1Stream.forEach(System.out::println);


        System.out.println();
        // 5. Limit: Display only the first 3 Book1s
        Stream<Book1> limitBook1 = Book1s.stream()
//                .sorted(Comparator.comparing(s -> s.publicationYear)) // if you want to sort by year and then want first three Book1
                .limit(3);
        limitBook1.forEach(System.out::println);

        System.out.println("========");
        // 6. Skip: Skip the first 2 Book1s
        Book1s.stream()
                .skip(2)
                .forEach(System.out::println);

    }
}
