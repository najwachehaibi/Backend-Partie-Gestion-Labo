package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AppRoleRepository;
import com.example.demo.dao.AppUserRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		AppUser user=appUserRepository.findByUsername(username);
		if(user!=null) throw new RuntimeException("User already exists");
		if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUser.setActived(true);
		appUserRepository.save(appUser);
		addRoleToUser(username,"USER");
		return appUser;
	}

	@Override
	public AppRole save(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser appUser=appUserRepository.findByUsername(username);
		AppRole appRole=appRoleRepository.findByRoleName(roleName);
		appUser.getRoles().add(appRole);

	}

}
