package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.domain.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "SELECT COUNT(id) FROM donations", nativeQuery = true)
    int numberOfDonations();

    @Query(value = "SELECT SUM(donation_quantity) FROM donations", nativeQuery = true)
    int numberOfBags();
}
