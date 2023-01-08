package com.cgm.crud.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.bl.service.EmployeeServices;

/**
 * <h2>MyUserDetailsService Class</h2>
 * <p>
 * Process for Displaying MyUserDetailsService
 * </p>
 * 
 * @author User
 *
 */
@Service("myUserDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

	/**
	 * <h2>employeeService</h2>
	 * <p>
	 * employeeService
	 * </p>
	 */
	@Autowired
	private EmployeeServices employeeService;

	/**
	 * <h2>loadUserByUsername</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeeDto employeeDto = employeeService.findByEmail(email);

		if (employeeDto == null) {
			throw new UsernameNotFoundException("Employee not found");
		}

		System.out.println("---employee found----");
		System.out.println("---employee found----" + employeeDto.getEmail());
		System.out.println("---employee found----" + employeeDto.getPassword());
		System.out.println("---employee found----" + employeeDto.getType());

		UserDetails user = new User(employeeDto.getEmail(), employeeDto.getPassword(),
				authorities(employeeDto.getType()));
		return user;
	}

	/**
	 * <h2>authorities</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param type
	 * @return
	 * @return List<GrantedAuthority>
	 */
	private List<GrantedAuthority> authorities(String type) {
		List<GrantedAuthority> setAuths = new ArrayList<GrantedAuthority>();

		if (Integer.parseInt(type) == 0) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		} else if (Integer.parseInt(type) == 1) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		return setAuths;
	}
}
