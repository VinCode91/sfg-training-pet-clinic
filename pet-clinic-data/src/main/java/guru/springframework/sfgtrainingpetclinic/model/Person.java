package guru.springframework.sfgtrainingpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "first_name")
    protected String firstName;
    @Column(name = "last_name")
    protected String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
