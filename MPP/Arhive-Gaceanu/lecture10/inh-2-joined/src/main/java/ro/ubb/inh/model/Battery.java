package ro.ubb.inh.model;

import lombok.*;

import javax.persistence.Entity;

/**
 * author: radu
 */


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Battery extends Product {
    private boolean rechargeable;

    public Battery(String name, int price, boolean rechargeable) {
        super(name, price);
        this.rechargeable = rechargeable;
    }
}
