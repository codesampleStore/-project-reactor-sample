package sample.com.projectreactorsample;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sample.com.projectreactorsample.Repository.ReservationRepository;
import sample.com.projectreactorsample.model.Reservation;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Log4j2
public class SampleDataInitializer {

  private final ReservationRepository repository;

  @EventListener(ApplicationReadyEvent.class)
  public void ready() {
    Flux<Reservation> reservations =
        Flux.just("Madhura", "Josh", "Olga", "Marcin", "Violetta", "Ria", "Stephan", "Dr. Syer")
        .map(name -> new Reservation(null, name))
        .flatMap(repository::save);

   this.repository
       .deleteAll()
       .thenMany(reservations)
       .thenMany(this.repository.findAll())
       .subscribe(log::info);

  }
}
