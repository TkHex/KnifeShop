package Kursach.KnifeShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "knife")
@Table(name = "knife")
public class KnifeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "knife_seq_gen")
    @SequenceGenerator(name = "knife_seq_gen", sequenceName = "knife_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_firm")
    private FirmsModel firmsModel;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "metal")
    private String metal;

    @Column(name = "lenght")
    private String lenght;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private CartModel cartModel;

    @Column(name = "rating")
    private Double rating;
}
