package com.example.appinterface;

import com.example.client.clientuser.service.ClientUserService;
import com.example.model.ClientUser;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 客户端用户管理接口
 */
@RestController
@RequestMapping(value = "/api/{version}/user/")
@Slf4j
@Api(value = "客户端用户管理", tags = "clientUser", description = "客户端用户管理",
		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//produces表示response的类型,consumes表示请求的类型
public class ClientUserController {
	
	final ClientUserService clientUserService;
	
	@Autowired
	public ClientUserController(ClientUserService clientUserService) {
		this.clientUserService = clientUserService;
	}
	
	@GetMapping(value = "login")
	public ClientUser login(String account, String password) {
		ClientUser clientUser = new ClientUser();
		clientUser.setAccount(account);
		clientUser.setPassword(password);
		
		return clientUserService.findClientUser(clientUser);
	}
	
	@PostMapping(value = "register")
	public ClientUser register(@RequestBody ClientUser clientUser) {
		return clientUserService.insert(clientUser);
	}
}
