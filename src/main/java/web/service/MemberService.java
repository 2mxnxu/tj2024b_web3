package web.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.entity.MemberEntity;
import web.model.repository.MemberEntityRepository;
import web.util.JWTUtil;

@Service // Spring MVC2 service
@RequiredArgsConstructor
@Transactional // 트랜잭션 : 여러개의 SQL 명령어 를 하나의 논리 단위 묶음
// 트랜잭션은 성공 또는 실패 , 부분 성공은 없다.
// 메소드 안에서 여러가지 SQL 실행할 경우 하나라도 오류가 발생하면 롤백(취소) * JPA 엔티티 수정 필수!
public class MemberService {
    private final MemberEntityRepository memberEntityRepository;

    // [1] 회원가입
    public boolean signUp(  MemberDto memberDto ){
        // 1.암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 암호화 비크립트 객체 생성
        String hashedPwd = passwordEncoder.encode( memberDto.getMpwd() ); // 암호화 지원하는 함수 .encode( 암호화할데이터 )
        memberDto.setMpwd( hashedPwd );
        // 2. DTO 를 entity 변환하기.
        MemberEntity memberEntity = memberDto.toEntity();
        // 3. 리포지토리 이용한 entity 영속화하기 , 영속된 결과 반환
        MemberEntity saveEntity = memberEntityRepository.save( memberEntity );
        // 4. 영속된 엔티티의 (자동생성된) pk 확인
        if( saveEntity.getMno() >= 1 ){ return true;}
        return false;
    }
    private final JWTUtil jwtUtil;

    public String login(MemberDto memberDto){
        MemberEntity memberEntity= memberEntityRepository.findByMemail(memberDto.getMemail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean inMatch = passwordEncoder.matches(memberDto.getMpwd(), memberEntity.getMpwd());
        if (inMatch == false) return null;
        String token
                = jwtUtil.createToken( memberEntity.getMemail() );
        System.out.println( ">>발급된 token : " + token );
        return token;
    }
    public MemberDto info(String token){
        String memail = jwtUtil.validateToken(token);
        if (memail == null) return null;
        MemberEntity memberEntity = memberEntityRepository.findByMemail(memail);
        if (memberEntity == null) return null;
        return memberEntity.toDto();
    }
    public void logout(String token){
        String memail = jwtUtil.validateToken(token);
        jwtUtil.deleteToken(memail);
    }
}