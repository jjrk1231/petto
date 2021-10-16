package com.example.petto.controller;

import com.example.petto.controller.request.MemberRequest;
import com.example.petto.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/petto/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/idDupliChk/{id}")
    public ResponseEntity<Boolean> idDupliChk(@PathVariable("id") String id) {
        log.info("idDupliChk(): " + id);

        boolean NoDupliId =  memberService.idDupliChk(id);

        return new ResponseEntity<Boolean>(NoDupliId, HttpStatus.OK);
    }

    @PostMapping("/nicknameDupliChk/{nickname}")
    public ResponseEntity<Boolean> nicknameDupliChk(@PathVariable("nickname") String nickname) {
        log.info("nicknameDupliChk(): " + nickname);

        boolean NoDupliNickname =  memberService.nicknameDupliChk(nickname);

        return new ResponseEntity<Boolean>(NoDupliNickname, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("signup(): " + memberRequest);

        memberService.signup(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/checkValidEmail")
    //@ResponseBody
    public ResponseEntity<String> checkValidEmail(@RequestParam("email") String email, @RequestParam("id") String id) {

        if(!id.equals("")) {
            log.info("checkValidEmail(): " + email + ", " + id);

            String confidentialCode = memberService.checkValidEmailForPw(email, id);

            return new ResponseEntity<String>(confidentialCode, HttpStatus.OK);

        } else {

            log.info("checkValidEmail(): " + email);

            boolean isEmailExists = memberService.checkValidEmail(email);

            String EmailExists = "NotEmailExists";
            if(isEmailExists) EmailExists = "EmailExists";

            return new ResponseEntity<String>(EmailExists, HttpStatus.OK);
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity<Void> changePassword(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("changePassword(): " + memberRequest);

        memberService.changePassword(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
