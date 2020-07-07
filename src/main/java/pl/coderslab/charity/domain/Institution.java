package pl.coderslab.charity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "institution_name")
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String name;

    @Column(name = "institution_description")
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String description;

}
