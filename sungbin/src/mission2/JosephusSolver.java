package mission2;

import java.util.List;

public class JosephusSolver {

    private final List<Integer> list;

    private final int k;

    public JosephusSolver(List<Integer> list, int k) {
        this.list = list;
        this.k = k;
    }

    /**
     * 1부터 n까지의 정수를 리스트에 추가하여 초기화.
     * @param n 전체 인원 수
     */
    public void initialize(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    /**
     * 요세푸스 문제를 해결하는 메서드로, 리스트에 한 명만 남을 때까지 k번째 요소를 제거.
     *
     * @return 마지막에 남은 사람의 번호
     */
    public int solve() {
        int currentIndex = 0;

        while (list.size() > 1) {
            currentIndex = (currentIndex + k - 1) % list.size();
            list.remove(currentIndex);
        }

        return list.getFirst();
    }
}
