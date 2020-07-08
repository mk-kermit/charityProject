package pl.coderslab.charity.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.coderslab.charity.util.validation.AddValidator;
import pl.coderslab.charity.util.validation.EditValidator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "donations")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "donation_quantity")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    int quantity;

    @Column(name = "donation_street")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    String street;

    @Column(name = "donation_city")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    String city;

    @Column(name = "donation_zipcode")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    String zipCode;

    @Column(name = "donation_pickup_date")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    LocalDate pickUpDate;

    @Column(name = "donation_pickup_time")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    LocalTime pickUpTime;

    @Column(name = "donation_pickup_comment")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    String pickUpComment;

    @ManyToOne
    Institution institution;

    @ManyToMany
    List<Category> categories = new ArrayList<>();
}
