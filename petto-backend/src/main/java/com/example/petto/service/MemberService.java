package com.example.petto.service;

import com.example.petto.controller.request.MemberRequest;
import com.example.petto.entity.Member;
import com.example.petto.entity.MemberRelated.LikedAnimal;
import com.example.petto.entity.MemberRelated.UpdateAlarm;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberService {

    @Transactional
    public boolean login(MemberRequest memberRequest) throws Exception;

    public boolean idDupliChk(String id);

    public boolean checkIdValidation(String id) throws Exception;

    public void signup(MemberRequest memberRequest);

    public boolean nicknameDupliChk(String nickname);

    public boolean checkValidEmail(String email, String birthday);

    public String checkValidEmailForPw(String email, String id);

    public void changePassword(MemberRequest memberRequest);

    public void modifyUserInfo(Member member);

    public void addLikedAnimal(LikedAnimal likedAnimal);

    public List<LikedAnimal> getlikedAnimalList(Integer memberNo);

    public void deleteLikedAnimal(LikedAnimal likedAnimal);

    public void removeUser(Long memberNo) throws Exception;

    public List<LikedAnimal> deleteContainingMemberNo(Long memberNo) throws Exception;

    public boolean passwordChk(MemberRequest memberRequest) throws Exception;

    public void updateAlarm(UpdateAlarm updateAlarm);

    public void deleteAlarms(Long alarmNo);

//    public List<LikedAnimal> selectLikeCnt() throws Exception;
    // 관리자?
//    List<Member> list() throws Exception;


}
