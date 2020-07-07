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
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "donation_quantity")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private int quantity;

    @Column(name = "donation_street")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private String street;

    @Column(name = "donation_city")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private String city;

    @Column(name = "donation_zipcode")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private String zipCode;

    @Column(name = "donation_pickup_date")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private LocalDate pickUpDate;

    @Column(name = "donation_pickup_time")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private LocalTime pickUpTime;

    @Column(name = "donation_pickup_comment")
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    private int pickUpComment;

    @ManyToOne
    private Institution institution;

    @OneToMany
    private List<Category> categories = new ArrayList<>();
}
