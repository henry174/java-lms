package nextstep.courses.domain;

import nextstep.users.domain.NsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 수강신청한 사용자들 목록
 * List<NsUser>의 일급 컬렉션입니다.
 */
public class RegisteredUsers {
    private List<NsUser> users = new ArrayList<>();

    public void add(NsUser user) {
        Optional<NsUser> searchResult = users.stream().filter(u -> u.equals(user)).findFirst();

        if (searchResult.isPresent()) {
            throw new IllegalArgumentException("중복되어 추가되는 유저: " + user);
        }

        users.add(user);
    }
}
