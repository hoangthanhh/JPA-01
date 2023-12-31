package HocSinh.demo.Controller;

import HocSinh.demo.Models.HocSinh;
import HocSinh.demo.Models.Lop;
import HocSinh.demo.Services.HocSinhServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/version1.0")
public class HocSinhController {
    @Autowired
    private HocSinhServices hocSinhServices;

    @RequestMapping(value = "them1hocsinhvao1lop", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocSinh them1HocSinhVao1Lop(@RequestBody String hocSinh) {

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                }
        ).create();
        HocSinh hs = gson.fromJson(hocSinh, HocSinh.class);
        return hocSinhServices.them1HocSinhVao1Lop(hs);
    }

    @RequestMapping(value = "suahocsinh", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocSinh suaHocSinh(@RequestBody String hocSinhSua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                }
        ).create();
        HocSinh hs = gson.fromJson(hocSinhSua, HocSinh.class);
        return hocSinhServices.suaHocSinh(hs);
    }

    @RequestMapping(value = "xoahocsinh", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocSinh removeHocSinh(@RequestParam int hocSinhId) {
        return hocSinhServices.xoaHocSinh(hocSinhId);
    }

    @RequestMapping(value = "chuyenlopchohocsinh", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocSinh chuyenLop(@RequestBody HocSinh hocSinh, Lop lopMoi) {
        return hocSinhServices.chuyenLop(hocSinh, lopMoi);
    }
}

