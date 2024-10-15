package Rastek_fix.demo.Controller;


import Rastek_fix.demo.DTO.*;
import Rastek_fix.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(
            path = "/api/addEmployee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<EmployeeRes> create(@RequestBody EmployeeReq request) {
        EmployeeRes employeeRes = employeeService.create(request);
        return WebResponse.<EmployeeRes>builder().data(employeeRes).build();
    }

    @GetMapping(
            path = "/api/addEmployee/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<EmployeeRes> get(@PathVariable("id") Long id){
        EmployeeRes employeeRes = employeeService.get(id);
        return WebResponse.<EmployeeRes>builder().data(employeeRes).build();
    }

    @PutMapping(
            path = "/api/addEmployee/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<EmployeeRes> update(@RequestBody UpdateEmployeeReq request,
                                           @PathVariable("NIK") Long NIK) {
        request.setNIK(NIK);
        EmployeeRes employeeRes = employeeService.update(request);
        return WebResponse.<EmployeeRes>builder().data(employeeRes).build();
    }

}
