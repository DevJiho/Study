import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class Countingreplyer{
    public static void main(String[] args) throws IOException {
        String token = "86b0e4b3831f817ea56162c824a30338eba2e63e";
        GitHub Git = new GitHubBuilder().withOAuthToken(token).build();
        //토큰을 이용한 Git 접근

        GHRepository Gitrepo = Git.getRepository("whiteship/live-study");
        //repo 접근.

        List<GHIssue> issues = Gitrepo.getIssues(GHIssueState.ALL);
        //Issues 접근.

        TreeMap<String, List<Integer>> UserInfo = new TreeMap<String, List<Integer>>();

        for(var item : issues){
            for(var reply : item.getComments()){
                List<Integer> list = new ArrayList<Integer>();
                if(UserInfo.get(reply.getUser().getLogin()) != null){
                    list = UserInfo.get(reply.getUser().getLogin());
                    UserInfo.remove(reply.getUser().getLogin());
                }
                list.add(item.getNumber());
                UserInfo.put(reply.getUser().getLogin(), list);
            }
        }

        Iterator<String> UserInfoIter = UserInfo.keySet().iterator();
        while(UserInfoIter.hasNext()) {
            String ID = UserInfoIter.next();
            List<Integer> list = UserInfo.get(ID);
            double per = ((double)list.size()/18) * 100;
            System.out.println("참여자 : " + ID + " , 참여율 : " + String.format("%.2f", per));
        }
    }
}
