
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_libraryCard")
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lib_card_id", length = 100, nullable = false, unique = true)
    private int id;
    @Column(name = "expiration_date", nullable = false, unique = false)
    private LocalDate expirationDate;

    @OneToOne(mappedBy = "libraryCard")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "id=" + id +
                ", expirationDate=" + expirationDate +
                ", student=" + student.getFirstName() + " " + student.getLastName() +
                '}';
    }




}