package massimiliano.AssegnaDispositivo.Service;

import massimiliano.AssegnaDispositivo.Entities.Dispositivo;
import massimiliano.AssegnaDispositivo.Exeptions.NotFoundExceptionDispositivo;
import massimiliano.AssegnaDispositivo.Payloads.DispositivoDTO;
import massimiliano.AssegnaDispositivo.Repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class DispositivoService {
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public Dispositivo save(DispositivoDTO body) {
        Dispositivo newDispositivo = new Dispositivo();

        newDispositivo.setTipo(body.tipo());
        newDispositivo.setStato(body.stato());
        return dispositivoRepository.save(newDispositivo);
    }

    public Page<Dispositivo> getDispositivo(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return dispositivoRepository.findAll(pageable);
    }

    public Dispositivo findById(int id) {

        return dispositivoRepository.findById(id).orElseThrow(() -> new NotFoundExceptionDispositivo(id));

    }

    public Dispositivo findAndUpdateById(int id, Dispositivo body) {
        Dispositivo found1 = this.findById(id);

        found1.setId(id);
        found1.setStato(body.getStato());
        found1.setTipo(body.getTipo());
        found1.setTempoDiassegnazione(body.getTempoDiassegnazione());

        return found1;

    }


    public void findAndDeleteById(int id) {
        Dispositivo found1 = this.findById(id);
        dispositivoRepository.delete(found1);
    }
}

