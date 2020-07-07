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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", unique = true, length = 80)
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private String name;
}
