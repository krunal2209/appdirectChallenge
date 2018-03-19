/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.appdirect.challenge.api;

import org.appdirect.challenge.dto.Response;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-18T18:45:19.434-04:00")

@Api(value = "subscription", description = "the subscription API")
public interface SubscriptionApi {

    @ApiOperation(value = "Cancel a subscription", notes = "", response = Response.class, tags={ "Subscription", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Response.class) })
    
    @RequestMapping(value = "/subscription/cancel",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Response> subscriptionCancelGet(@ApiParam(value = "") @RequestParam(value = "eventUrl", required = false) String eventUrl) {
        // do some magic!
        return new ResponseEntity<Response>(HttpStatus.OK);
    }


    @ApiOperation(value = "Modify a subscription", notes = "", response = Response.class, tags={ "Subscription", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Response.class) })
    
    @RequestMapping(value = "/subscription/change",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Response> subscriptionChangeGet(@ApiParam(value = "") @RequestParam(value = "eventUrl", required = false) String eventUrl) {
        // do some magic!
        return new ResponseEntity<Response>(HttpStatus.OK);
    }


    @ApiOperation(value = "Create a new subscription", notes = "", response = Response.class, tags={ "Subscription", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Response.class) })
    
    @RequestMapping(value = "/subscription/create",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Response> subscriptionCreateGet(@ApiParam(value = "") @RequestParam(value = "eventUrl", required = false) String eventUrl) {
        // do some magic!
        return new ResponseEntity<Response>(HttpStatus.OK);
    }


    @ApiOperation(value = "Notification of the subscription", notes = "", response = Response.class, tags={ "Subscription", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Response.class) })
    
    @RequestMapping(value = "/subscription/notification",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Response> subscriptionNotificationGet(@ApiParam(value = "") @RequestParam(value = "eventUrl", required = false) String eventUrl) {
        // do some magic!
        return new ResponseEntity<Response>(HttpStatus.OK);
    }

}
