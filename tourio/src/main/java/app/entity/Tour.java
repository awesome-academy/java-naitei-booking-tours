package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tour {

    @Id
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String duration;
    private String place;
    private String images;

    @Column(name = "category_id", insertable = false, updatable = false)
    private Integer categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
