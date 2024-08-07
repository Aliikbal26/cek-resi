package aliikbal.cek_resi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aliikbal.cek_resi.Entity.Resi;
import aliikbal.cek_resi.Model.BinderbyteResponse;
import aliikbal.cek_resi.Repository.ResiRepository;
import aliikbal.cek_resi.Service.ResiService;

@Controller
@RequestMapping("/resi")
public class ResiController {
    @Autowired
    private ResiService resiService;

    // @GetMapping("/")
    // public ResponseEntity<BinderbyteResponse> cekResi(
    // @RequestParam String awb,
    // @RequestParam String courier) {

    // BinderbyteResponse response = resiService.cekResi(courier, awb);
    // if (response == null || !response.getStatus().equalsIgnoreCase("200")) {
    // return ResponseEntity.notFound().build();
    // }
    // return ResponseEntity.ok(response);
    // }

    @GetMapping("/")
    public String cekResi(
            @RequestParam(name = "awb", required = false) String awb,
            @RequestParam(name = "courier", required = false) String courier,
            Model model) {

        if (awb != null && courier != null) {
            BinderbyteResponse response = resiService.cekResi(courier, awb);
            model.addAttribute("response", response);
        }
        return "cekResi";
    }
}
