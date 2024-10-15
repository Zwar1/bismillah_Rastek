package Rastek_fix.demo.Controller;

import Rastek_fix.demo.DTO.*;
import Rastek_fix.demo.Service.JabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class JabatanController {

    @Autowired
    JabatanService jabatanService;

    @PostMapping(
            path = "/api/addJabatan",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<JabatanRes> create(@RequestBody JabatanReq request) {
        JabatanRes jabatanRes = jabatanService.create(request);
        return WebResponse.<JabatanRes>builder().data(jabatanRes).build();
    }

    @GetMapping(
            path = "/api/addJabatan/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<JabatanRes> get(@PathVariable("id") Long id){
        JabatanRes jabatan = jabatanService.get(id);
        return WebResponse.<JabatanRes>builder().data(jabatan).build();
    }

    @PutMapping(
            path = "/api/addJabatan/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<JabatanRes> update(@RequestBody UpdateJabatanReq request,
                                           @PathVariable("id") Long id) {
        request.setId(id);
        JabatanRes jabatanRes = jabatanService.update(request);
        return WebResponse.<JabatanRes>builder().data(jabatanRes).build();
    }
}
