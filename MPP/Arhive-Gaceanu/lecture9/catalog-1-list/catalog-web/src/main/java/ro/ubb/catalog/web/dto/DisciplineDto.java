package ro.ubb.catalog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: radu
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DisciplineDto extends BaseDto{
    private String title;

    @Override
    public String toString() {
        return "DisciplineDto{" +
               "title='" + title + '\'' +
               "} " + super.toString();
    }
}
