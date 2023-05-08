package unique;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final Set<String> allNicknames = new HashSet<>();
    private String nickname;

    public Player(String nickname) throws Exception {
        if (allNicknames.contains(nickname)) {
            throw new Exception("A player with this nickname already exists!");
        }
        allNicknames.add(nickname);
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }
}
