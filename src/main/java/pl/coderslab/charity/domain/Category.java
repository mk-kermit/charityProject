package pl.coderslab.charity.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.coderslab.charity.util.validation.AddValidator;
import pl.coderslab.charity.util.validation.EditValidator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "category_name", unique = true, length = 80)
//    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
//    @NotNull(groups = {AddValidator.class, EditValidator.class})
    String name;

}
