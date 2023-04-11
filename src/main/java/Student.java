
import javax.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id", length = 100, nullable = false, unique = true)
    private int id;
    @Column(name = "first_name", length = 100, nullable = false, unique = false)
    private String firstName;
    @Column(name = "last_name", length = 100, nullable = false, unique = false)
    private String lastName;


    @OneToOne
    @JoinColumn(name = "library_card_id")
    private LibraryCard libraryCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", libraryCard=" + libraryCard +
                '}';
    }
}