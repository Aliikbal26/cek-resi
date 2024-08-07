package aliikbal.cek_resi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aliikbal.cek_resi.Entity.Resi;

public interface ResiRepository extends JpaRepository<Resi, Long> {

    Resi findByNomorResi(String nomorResi);

}
