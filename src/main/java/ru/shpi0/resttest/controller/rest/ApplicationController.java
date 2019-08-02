package ru.shpi0.resttest.controller.rest;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shpi0.resttest.dto.ApplicationDto;
import ru.shpi0.resttest.model.Application;
import ru.shpi0.resttest.service.ApplicationService;

import java.util.Optional;

@RestController()
@RequestMapping("/api/application")
@Api(value = "\"Application\" API", description = "API methods for Application entity")
public class ApplicationController {

    private static Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(value = "/contact/{id}", produces = {"application/xml", "application/json"})
    @ApiOperation(value = "Get last application by contact id", response = ApplicationDto.class, httpMethod = "GET", produces = "application/xml, application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful get last application"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Application by contact id not found")
    })
    public ResponseEntity<ApplicationDto> getLastApplicationByContactId(
            @ApiParam(name = "id", value = "Contact id", required = true, example = "1") @PathVariable Long id,
            @ApiParam(name = "xml", value = "Key for return result as XML", example = "true") @RequestParam(required = false) String xml) {
        logger.info("getLastApplicationByContactId {}", id);
        Optional<Application> result = applicationService.getLastApplicationByContactId(id);
        if (result.isPresent()) {
            ApplicationDto dto = new ApplicationDto(id, result.get());
            if ("true".equals(xml)) {
                logger.info("Returning XML {}", dto);
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(dto);
            }
            logger.info("Returning JSON {}", dto);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(dto);
        }
        logger.info("Entity with id {} not found", id);
        return ResponseEntity.notFound().build();
    }

}
