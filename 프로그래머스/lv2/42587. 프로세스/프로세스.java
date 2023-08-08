import java.util.*;

class Solution {

    static class  paper {
        int pr;
        int loc;

        paper(int pr, int loc)
        {
            this.pr = pr;
            this.loc = loc;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;

        Stack<paper> st = new Stack<paper>();
        ArrayList<Integer> array = new ArrayList<>();

        for(int i=0; i<priorities.length; i++)
        {
            paper pr = new paper(priorities[i], i);
            st.add(pr);

            array.add(priorities[i]);
        }

        array.sort(Comparator.reverseOrder());

        int maxPri = array.get(0);

        while(!st.empty())
        {
            paper pr = st.firstElement();
            st.remove(0);

            if(maxPri == pr.pr)
            {
                array.remove(0);
                array.sort(Comparator.reverseOrder());
                if(!st.empty()) maxPri = array.get(0);
                cnt ++;

                if(pr.loc == location)
                {
                    answer = cnt;
                }
            }
            else
            {
                st.add(pr);
            }
        }

        return answer;
    }
}