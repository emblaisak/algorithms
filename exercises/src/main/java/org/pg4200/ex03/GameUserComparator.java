package org.pg4200.ex03;

import java.util.Comparator;

public class GameUserComparator implements Comparator<GameUser> {

    //        Returns positive number if sorted
    //        Returns 0 if equal
    //        Returns negative if not sorted

    @Override
    public int compare(GameUser userOne, GameUser userTwo) {
        int result;

        int firstUserPoints = userOne.getPoints();
        int secondUserPoints = userTwo.getPoints();

        if (firstUserPoints == secondUserPoints) {
            result = userOne.getUserId().compareTo(userTwo.getUserId());
        } else {
            result = Integer.compare(firstUserPoints, secondUserPoints);
        }

        return result;
    }
}
