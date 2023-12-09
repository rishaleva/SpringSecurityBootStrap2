package ru.rishaleva.springBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.rishaleva.springBootSecurity.model.User;
import ru.rishaleva.springBootSecurity.repository.RoleRepository;
import ru.rishaleva.springBootSecurity.service.RoleService;
import ru.rishaleva.springBootSecurity.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
//ALL
    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    //HIM
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }
// CREATE
    @GetMapping("/new")
    public String CreateUserForm(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("role",roleService.getRoles());
        return "userCreate";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/user";
    }
// DELETE
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin/user";
    }
// UPDATE
        @GetMapping("/update")
        public String getEditUserForm(Model model, @RequestParam("id") Long id) {
            model.addAttribute("user", userService.getUser(id));
            model.addAttribute("role",roleService.getRoles());
            return "/userUpdate";
        }

        @PatchMapping("/user/{id}")
        public String saveUpdateUser(@ModelAttribute("user") User user) {
            userService.updateUser(user);
            return "redirect:/admin/user";
        }
//
}
