package com.example.api;

import com.example.user.model.User;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date =
		"2017-08-02T03:21:02.511Z")

@Controller
public class InventoryApiController implements InventoryApi {
	
	public ResponseEntity<Void> addInventory(@ApiParam(value = "Inventory item to add") @RequestBody User
			                                         inventoryItem) {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<List<User>> searchInventory(@ApiParam(value = "pass an optional search string for looking up" +
			" " +
			"inventory") @RequestParam(value = "searchString", required = false) String searchString,
	                                                  @ApiParam(value = "number of records to skip for pagination")
	                                                  @RequestParam(value = "skip", required = false) Integer skip,
	                                                  @ApiParam(value = "maximum number of records to return")
	                                                  @RequestParam(value = "limit", required = false) Integer limit) {
		// do some magic!
		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
	
}
