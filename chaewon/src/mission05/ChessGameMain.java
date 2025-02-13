package collection.iterator.mission04;

import java.util.List;

public class ChessGameMain {
    public static void main(String[] args) {
        ChessGameManager manager = new ChessGameManager();

        //플레이어 추가
        manager.addPlayer("고길동");
        manager.addPlayer("둘리");
        manager.addPlayer("또치");
        manager.addPlayer("마이콜");

        //경기 결과 기록 - 정상 기록
        manager.recordMatch("고길동", "둘리");
        manager.recordMatch("또치", "둘리");
        manager.recordMatch("고길동", "또치");
        manager.recordMatch("마이콜", "또치");
        manager.recordMatch("고길동", "마이콜");

//        경기 결과 기록 - 플레이어 조회 불가로 미등록
//        manager.recordMatch("도우너", "둘리");

//        경기 결과 기록 - 승자와 패자 이름 일치
//        manager.recordMatch("고길동", "고길동");

        //전체 플레이어와 스코어 조회
        List<Player> scores = manager.getScores();
        System.out.println(scores);

        //탑 스코어 플레이어 조회
        Player topPlayer = manager.getTopPlayer();
        System.out.println(topPlayer);

        //승리 수 정렬
        manager.sortByWins();
        manager.getScores();

        //특정 플레이어 승수
        int wins = manager.numOfMatches("고길동");
        System.out.println(wins);

        //점수 필터링 후 조회
        List<Player> filterByScore = manager.filterByScore(-10);
        System.out.println(filterByScore);

        //최고 승률 플레이어 조회
        Player bestWiniRatePlayer = manager.getBestWiniRatePlayer();
        System.out.println(bestWiniRatePlayer);
    }
}
