package tn.esprit.consomitounsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidv.consomiTounsi.webservices.model.Rayon;

@Repository
public interface StockRepository extends JpaRepository<Rayon, Long> {

}
