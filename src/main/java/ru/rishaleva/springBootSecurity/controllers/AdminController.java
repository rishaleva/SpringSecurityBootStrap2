package ru.rishaleva.springBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.rishaleva.springBootSecurity.model.Role;
import ru.rishaleva.springBootSecurity.model.User;
import ru.rishaleva.springBootSecurity.repository.RoleRepository;
import ru.rishaleva.springBootSecurity.service.RoleService;
import ru.rishaleva.springBootSecurity.service.UserService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
//ALL
    @GetMapping(value = "/")
    public String getAllUsers(ModelMap model, Principal principal) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        List<User> listOfUsers = userService.getAllUsers();
        model.addAttribute("listOfUsers",listOfUsers);
        return "users";
    }
// CREATE
    @GetMapping("/new")
    public String CreateUserForm(ModelMap model) {
        model.addAttribute("user",new User());
        Collection<Role> roles = roleService.getRoles();
        model.addAttribute("role",roles);
        return "userCreate";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/";
    }
// DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin/";
    }
// UPDATE
        @GetMapping("/{id}/update")
        public String getEditUserForm(ModelMap model, @PathVariable("id") Long id) {
            model.addAttribute("user", userService.getUser(id));
            return "userUpdate";
        }

        @PatchMapping("/{id}")
        public String saveUpdateUser(@ModelAttribute("user") User user,@PathVariable("id") Long id) {
            userService.updateUser(user);
            return "redirect:/admin/";
        }
//
}
