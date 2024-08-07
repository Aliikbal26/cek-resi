package aliikbal.cek_resi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aliikbal.cek_resi.Model.BinderbyteResponse;

@Service
public class ResiService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${binderbyte.api.key}")
    private String apiKey;

    public BinderbyteResponse cekResi(String courier, String nomorResi) {
        String url = "https://api.binderbyte.com/v1/track?api_key=" + apiKey + "&courier=" + courier + "&awb="
                + nomorResi;

        // String url = "https://api.binderbyte.com/v1/track?api_key=" + apiKey +
        // "&courier=jne&awb=" + nomorResi;
        return restTemplate.getForObject(url, BinderbyteResponse.class);
    }
}
