package sample.com.projectreactorsample.Repository;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import sample.com.projectreactorsample.model.Reservation;

public interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {

  @Tailable
  Flux<Reservation> findByName(String name);
}
