package Rastek_fix.demo.Controller;

import Rastek_fix.demo.DTO.*;
import Rastek_fix.demo.Service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DivisionController {

    @Autowired
    DivisionService divisionService;

    @PostMapping(
            path = "/api/addDivision",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<DivisionRes> create(@RequestBody DivisionReq request) {
        DivisionRes divisionRes = divisionService.create(request);
        return WebResponse.<DivisionRes>builder().data(divisionRes).build();
    }


    //Get API
    @GetMapping(
            path = "/api/addDivision/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<DivisionRes> get(@PathVariable("id") Long id){
        DivisionRes divisionRes = divisionService.get(id);
        return WebResponse.<DivisionRes>builder().data(divisionRes).build();
    }

    //Put API
    @PutMapping(
            path = "/api/addDivision/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<DivisionRes> update(@RequestBody UpdateDivisionReq request,
                                              @PathVariable("id") Long id) {
        request.setId(id);
        DivisionRes divisionRes = divisionService.update(request);
        return WebResponse.<DivisionRes>builder().data(divisionRes).build();
    }

}
