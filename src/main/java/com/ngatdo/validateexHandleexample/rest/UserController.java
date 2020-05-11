package com.ngatdo.validateexHandleexample.rest;

import com.ngatdo.validateexHandleexample.entity.UserEnt;
import com.ngatdo.validateexHandleexample.exception.InvalidUserIDException;
import com.ngatdo.validateexHandleexample.exception.RecordNotFoundException;
import com.ngatdo.validateexHandleexample.repository.UserRepository;
import com.ngatdo.validateexHandleexample.service.ValidatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.InvalidNameException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ValidatingService validatingService;

    /**
     * Service thêm mới user
     * validate dữ liệu (chỉ validate dựa trên các annotation trong Entity) ngay từ khi convert từ JSON sang Ent
     * @param user
     * @return
     */
    @PostMapping(value = "/user/add/1")
    public ResponseEntity<UserEnt> addUser1(@RequestBody @Valid UserEnt user)
    {
        user.setExpired(1);
        user.setDisabled(0);
        userRepository.save(user);
        return new ResponseEntity<UserEnt>(user, HttpStatus.OK);
    }

    /**
     * Service thêm mới user
     * Không validate dữ liệu khi convert từ JSON sang Ent
     * Validate dữ liệu sau đó dùng validatingService(validate dựa trên annotation trong Entity và customized validation
     * @param user
     * @return
     */

    @PostMapping(value = "/user/add/2")
    public ResponseEntity<UserEnt> addUser2(@RequestBody  UserEnt user) throws InvalidUserIDException {
        user.setExpired(1);
        user.setDisabled(0);
        validatingService.customizedValidate(user);
        userRepository.save(user);
        return new ResponseEntity<UserEnt>(user, HttpStatus.OK);
    }

    /**
     * Service lấy thông tin User theo id
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserEnt> findById (@PathVariable("id") Long id)
    {
        Optional<UserEnt> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new RecordNotFoundException("Invalid user id : " + id);
        }
        return new ResponseEntity<UserEnt>(user.get(), HttpStatus.OK);
    }
}
