package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tour_available")
@NoArgsConstructor
@Getter
@Setter
public class TourAvailable {

    public enum Available {
        YES, NO
    }

    @Id
    private Integer id;

    @Column(name = "tour_id", insertable = false, updatable = false)
    private Integer tourId;
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column(name = "actual_cost")
    private Double actualCost;
    private Date start;
    @Column(name = "is_available")
    @Enumerated(EnumType.STRING)
    private Available available;
}
