package test.hackathonTest.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private int age;
    private List <Long> activityIdList;

}
//@NoArgsConstructor: Genera un constructor sin argumentos.
//@AllArgsConstructor: Genera un constructor con todos los campos.
//@RequiredArgsConstructor: Genera un constructor solo para los campos que son final o están marcados como @NonNull.
