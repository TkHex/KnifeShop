package Kursach.KnifeShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "firm")
@Table(name = "firm")
public class FirmsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "firm_seq_gen")
    @SequenceGenerator(name = "firm_seq_gen", sequenceName = "firm_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "firm_name")
    private String firm_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;
}
