package core.controller;

import org.springframework.web.bind.annotation.*;
import core.model.DispatcherAddResponse;

@RestController
public class DispatcherController {
    @GetMapping("/dispatchers")
    public String showAllDispatchers() {
        return "Dispatchers list";
    }

    @PostMapping("/dispatcher/add")
    public DispatcherAddResponse addDispatcher(@RequestBody String name) {
        DispatcherAddResponse response = new DispatcherAddResponse();
        response.setName("Диспетчер - "+ name);

        return response;
    }

    /* http://localhost:8080/dispatcher/name?v=1*/
    @RequestMapping(value = "/dispatcher/{name}", method = RequestMethod.GET)
    public DispatcherAddResponse DispatcherName(@PathVariable String name, @RequestParam(value = "v", required = false) Integer version) {
        DispatcherAddResponse response = new DispatcherAddResponse();

        if (version == null) {
            response.setName("Unknown version");
        } else {
            response.setName("Диспетчер - "+ name);
        }

        return response;
    }
}
