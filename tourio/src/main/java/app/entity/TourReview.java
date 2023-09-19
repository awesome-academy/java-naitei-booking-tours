package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tour_review")
@NoArgsConstructor
@Getter
@Setter
public class TourReview {

    enum Status {
        WAITING, APPROVED, DECLINED
    }

    @Id
    private Integer id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "tour_id", insertable = false, updatable = false)
    private Integer tourId;
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    private String content;
    @Column(name = "time_created")
    private Date timeCreated;
    private Status status;
}
