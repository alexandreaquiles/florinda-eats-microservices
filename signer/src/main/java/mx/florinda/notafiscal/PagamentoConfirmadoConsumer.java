package mx.florinda.notafiscal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PagamentoConfirmadoConsumer {

  @Inject
  Hash hash;

  public Uni<Void> consome(PagamentoConfirmadoEvent evento) {
    System.out.println(evento);
    String hashGerado = hash.geraHash(evento.toString());
    System.out.println(hashGerado);
    return Uni.createFrom().voidItem();
  }

}
