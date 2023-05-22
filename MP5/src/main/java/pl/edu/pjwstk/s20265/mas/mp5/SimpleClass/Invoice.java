package pl.edu.pjwstk.s20265.mas.mp5.SimpleClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;
    private BigDecimal total;

    public Invoice() {
    }

    public Invoice(LocalDateTime date, BigDecimal total) {
        this.date = date;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
