package javapoz24.team3.rental.domain.booking;

import javapoz24.team3.rental.domain.base.BaseEntity;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.rentact.RentAct;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Booking extends BaseEntity {

    @CreatedDate
    private LocalDateTime createdTimestamp;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Car car;
    private LocalDate rentalDay;
    private LocalDate returnDay;
    @ManyToOne
    private CompanyBranch rentBranch;
    @ManyToOne
    private CompanyBranch returnBranch;
    @OneToOne(mappedBy = "referenceBooking")
    private RentAct rentAct;

    @Transient
    private BigDecimal totalCost;

    @PostLoad
    private void postLoad() {
        if (rentalDay != null && returnDay != null && !(returnDay.isBefore(rentalDay)) &&
         car != null) {
            long rentDuration = ChronoUnit.DAYS.between(rentalDay, returnDay);
            if (rentDuration > 0) {
                totalCost = car.getPricing().multiply(BigDecimal.valueOf(rentDuration));
            } else {
                totalCost = car.getPricing();
            }
        } else {
            totalCost = BigDecimal.ZERO;
        }
    }

    @Builder
    public Booking(Long id, Customer customer, Employee employee, Car car,
                   LocalDate rentalDay, LocalDate returnDay,
                   CompanyBranch rentBranch, CompanyBranch returnBranch,
                   RentAct rentAct
                   ) {
        this.setId(id);
        this.customer = customer;
        this.employee = employee;
        this.car = car;
        this.rentalDay = rentalDay;
        this.returnDay = returnDay;
        this.rentBranch = rentBranch;
        this.returnBranch = returnBranch;
        this.rentAct = rentAct;
    }
}
