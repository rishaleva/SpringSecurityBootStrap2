package ru.rishaleva.springBootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rishaleva.springBootSecurity.model.Role;
import ru.rishaleva.springBootSecurity.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> getRoles() {
        List<Role> list = roleRepository.findAll();
        return new HashSet<>(list);
    }
}
