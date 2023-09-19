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
public class Booking {

    enum Status {
        WAITING, APPROVED, DECLINED
    }

    @Id
    private Integer id;

    @Column(name = "tour_available_id", insertable = false, updatable = false)
    private Integer tourAvailableId;
    @ManyToOne
    @JoinColumn(name = "tour_available_id")
    private TourAvailable tourAvailable;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Status status;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column(name = "contact_email")
    private String contactEmail;
    private Integer quantity;
}
