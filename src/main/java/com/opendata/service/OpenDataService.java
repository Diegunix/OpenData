package com.opendata.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;

import org.springframework.stereotype.Service;

import com.opendata.dao.domain.Air;
import com.opendata.dao.domain.Estacion;
import com.opendata.dao.domain.Localidad;
import com.opendata.dao.domain.Magnitud;
import com.opendata.dao.domain.Provincia;
import com.opendata.dao.repository.AirRepository;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class OpenDataService {

    private final String URL = "http://www.mambiente.munimadrid.es/opendata/horario.txt";

    private AirRepository airRepository;

    public OpenDataService(AirRepository airRepository) {
        this.airRepository = airRepository;
    }

    public void getData() throws IOException {
        String data = doRequest(URL);
        String SEPARATOR = "\n";
        String SEPARATOR_ROW = ",";
        String[] rows = data.split(SEPARATOR);

        for (String row : rows) {
            String[] fields = row.split(SEPARATOR_ROW);
            Air air = parseFields(fields);
            airRepository.save(air);
        }
    }

    private Air parseFields(String[] fields) {
        Air air = new Air();

        air.setId(Long.parseLong(fields[0] + fields[1] + fields[2] + fields[3] + fields[6] + fields[7] + fields[8]));

        air.setLocalidad(Localidad.builder().id(Integer.parseInt(fields[1]))
                .provincia(Provincia.builder().id(Integer.parseInt(fields[0])).build()).build());
        air.setEstacion(Estacion.builder().id(Long.parseLong(fields[2])).build());
        air.setMagnitud(Magnitud.builder().id(Long.parseLong(fields[3])).build());
        air.setAno(Integer.parseInt(fields[6]));
        air.setMes(Integer.parseInt(fields[7]));
        air.setDia(Integer.parseInt(fields[8]));

        air.setH01(BigDecimal.valueOf(Double.parseDouble(fields[9])));
        air.setH02(BigDecimal.valueOf(Double.parseDouble(fields[11])));
        air.setH03(BigDecimal.valueOf(Double.parseDouble(fields[13])));
        air.setH04(BigDecimal.valueOf(Double.parseDouble(fields[15])));
        air.setH05(BigDecimal.valueOf(Double.parseDouble(fields[17])));
        air.setH06(BigDecimal.valueOf(Double.parseDouble(fields[19])));
        air.setH07(BigDecimal.valueOf(Double.parseDouble(fields[21])));
        air.setH08(BigDecimal.valueOf(Double.parseDouble(fields[23])));
        air.setH09(BigDecimal.valueOf(Double.parseDouble(fields[25])));
        air.setH10(BigDecimal.valueOf(Double.parseDouble(fields[27])));
        air.setH11(BigDecimal.valueOf(Double.parseDouble(fields[29])));
        air.setH12(BigDecimal.valueOf(Double.parseDouble(fields[31])));
        air.setH13(BigDecimal.valueOf(Double.parseDouble(fields[33])));
        air.setH14(BigDecimal.valueOf(Double.parseDouble(fields[35])));
        air.setH15(BigDecimal.valueOf(Double.parseDouble(fields[37])));
        air.setH16(BigDecimal.valueOf(Double.parseDouble(fields[39])));
        air.setH17(BigDecimal.valueOf(Double.parseDouble(fields[41])));
        air.setH18(BigDecimal.valueOf(Double.parseDouble(fields[43])));
        air.setH19(BigDecimal.valueOf(Double.parseDouble(fields[45])));
        air.setH20(BigDecimal.valueOf(Double.parseDouble(fields[47])));
        air.setH21(BigDecimal.valueOf(Double.parseDouble(fields[49])));
        air.setH22(BigDecimal.valueOf(Double.parseDouble(fields[51])));
        air.setH23(BigDecimal.valueOf(Double.parseDouble(fields[53])));
        air.setH24(BigDecimal.valueOf(Double.parseDouble(fields[55])));

        return air;
    }

    private String doRequest(String url) throws IOException {
        String hostname = "10.1.0.222";
        int port = 8080;
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port));

        OkHttpClient client = new OkHttpClient();
        client.setProxy(proxy);

        Request request = new Request.Builder().url(url).get().addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        String data = new String(response.body().string().getBytes(Charset.forName("UTF-8")));

        return data;
    }
}
