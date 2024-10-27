package mx.florinda.pagamento;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/pagamentos")
public class PagamentoResource {

  @GET
  public Uni<List<Pagamento>> lista() {
    return Pagamento.listAll();
  }

  @GET
  @Path("/{id}")
  public Uni<Pagamento> porId(Long id) {
    return Pagamento.findById(id);
  }

}
