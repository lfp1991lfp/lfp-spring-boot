package com.example.api;

import com.example.user.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date =
		"2017-08-02T03:21:02.511Z")

@Api(value = "inventory", description = "the inventory API")
public interface InventoryApi {
	
	@ApiOperation(value = "adds an inventory item", notes = "Adds an item to the system", response = Void.class, tags =
			{"admins",})
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "item created", response = Void.class),
			@ApiResponse(code = 400, message = "invalid input, object invalid", response = Void.class),
			@ApiResponse(code = 409, message = "an existing item already exists", response = Void.class)})
	@RequestMapping(value = "/inventory",
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.POST)
	ResponseEntity<Void> addInventory(@ApiParam(value = "Inventory item to add") @RequestBody User
			                                  inventoryItem);
	
	
	@ApiOperation(value = "searches inventory", notes = "By passing in the appropriate options, you can search for " +
			"available inventory in the system ", response = User.class, responseContainer = "List", tags = {"developers",})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search results matching criteria", response = User.class),
			@ApiResponse(code = 400, message = "bad input parameter", response = User.class)})
	@RequestMapping(value = "/inventory",
			produces = {"application/json"},
			method = RequestMethod.GET)
	ResponseEntity<List<User>> searchInventory(@ApiParam(value = "pass an optional search string for looking" +
			" up inventory") @RequestParam(value = "searchString", required = false) String searchString,
	                                           @ApiParam(value = "number of records to skip for pagination")
	                                           @RequestParam(value = "skip", required = false) Integer skip,
	                                           @ApiParam(value = "maximum number of records to return") @RequestParam
			                                           (value = "limit", required = false) Integer limit);
	
}
