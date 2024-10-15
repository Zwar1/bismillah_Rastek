package Rastek_fix.demo.Controller;

import Rastek_fix.demo.DTO.*;
import Rastek_fix.demo.Service.SubDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubDivisionController {

    @Autowired
    SubDivisionService subDivisionService;

    @PostMapping(
            path = "/api/addSubDivision",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SubDivisionRes> create(@RequestBody SubDivisionReq request) {
        SubDivisionRes subDivisionRes = subDivisionService.create(request);
        return WebResponse.<SubDivisionRes>builder().data(subDivisionRes).build();
    }


    //Get API
    @GetMapping(
            path = "/api/addSubDivision/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SubDivisionRes> get(@PathVariable("id") Long id){
        SubDivisionRes subDivisionRes = subDivisionService.get(id);
        return WebResponse.<SubDivisionRes>builder().data(subDivisionRes).build();
    }

    //Put API
    @PutMapping(
            path = "/api/addSubDivision/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SubDivisionRes> update(@RequestBody UpdateSubDivisionReq request,
                                           @PathVariable("id") Long id) {
        request.setId(id);
        SubDivisionRes subDivisionRes = subDivisionService.update(request);
        return WebResponse.<SubDivisionRes>builder().data(subDivisionRes).build();
    }
}
