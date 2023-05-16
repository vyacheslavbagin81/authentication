package PersonalData;
import Roles.Role;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Personal_data")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(name = "data_creation")
    private LocalDateTime dateAndTimeOfProfileCreation;
    @Column(name = "data_modification")
    private LocalDateTime dateAndTimeOfProfileModification;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "data_role",
            joinColumns = @JoinColumn(name = "personal_data_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;

    @Override
    public String toString() {
        return "PersonalData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateAndTimeOfProfileCreation=" + dateAndTimeOfProfileCreation +
                ", dateAndTimeOfProfileModification=" + dateAndTimeOfProfileModification +
                '}';
    }
}



