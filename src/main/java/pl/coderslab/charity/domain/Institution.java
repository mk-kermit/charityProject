package pl.coderslab.charity.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.coderslab.charity.util.validation.AddValidator;
import pl.coderslab.charity.util.validation.EditValidator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "institutions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "institution_name")
//    @NotNull(groups = {AddValidator.class, EditValidator.class})
//    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    String name;

    @Column(name = "institution_description")
//    @NotNull(groups = {AddValidator.class, EditValidator.class})
//    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    String description;

}
