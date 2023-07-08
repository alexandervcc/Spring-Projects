package acc.spring.jwtsecurity.controller;

import acc.spring.jwtsecurity.dto.RoleToUserDTO;
import acc.spring.jwtsecurity.model.AppUser;
import acc.spring.jwtsecurity.model.Role;
import acc.spring.jwtsecurity.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> postSaveUser(@RequestBody AppUser user){
        URI uri = URI.create(
            ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/user/save")
                .toUriString()
        );
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> postSaveRole(@RequestBody Role role){
        URI uri = URI.create(
            ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/role/save")
                .toUriString()
        );
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/add_user")
    public ResponseEntity<?> postSaveRoleToUser(@RequestBody RoleToUserDTO form){
        userService.addRoleToUser(form.getRole(),form.getUsername());
        return ResponseEntity.ok().build() ;
    }

}
