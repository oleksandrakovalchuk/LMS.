import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Books {
    private static List<String> books;

    public Books() {
        this.books = createBookList();
    }

    private List<String> createBookList() {
        List<String> books = new ArrayList<>();
        books.add("Computer Organization and Design: The Hardware/Software Interface by David A. Patterson, John L. Hennessy");
        books.add("Digital Design and Computer Architecture by David Money Harris, Sarah L. Harris");
        books.add("Introduction to the Theory of Computation by Michael Sipser");
        books.add("Computer Systems: A Programmer's Perspective by Randal E. Bryant, David R. O'Hallaron");
        books.add("Logic and Computer Design Fundamentals by M. Morris Mano, Charles R. Kime");
        books.add("Computer Architecture: A Quantitative Approach by John L. Hennessy, David A. Patterson");
        books.add("Computer Organization and Architecture: Designing for Performance by William Stallings");
        books.add("Computer Networks by Andrew S. Tanenbaum, David J. Wetherall");
        books.add("Modern Operating Systems by Andrew S. Tanenbaum");
        books.add("Computer Graphics: Principles and Practice by John F. Hughes, Andries van Dam, Morgan McGuire, David F. Sklar, James D. Foley, Steven K. Feiner, Kurt Akeley");

        return books;
    }

    public List<String> getBooks() {
        return books;
    }

    
    public static List<String> getRandomBooks(int count) {
        List<String> shuffledBooks = new ArrayList<>(books);
        Collections.shuffle(shuffledBooks);
;
        return shuffledBooks.subList(0, count);
    }


  
    }

