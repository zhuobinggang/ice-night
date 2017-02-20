package hello.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
@Repository("managerDao")
public class ManagerDao {
    List<String> users;
    List<String> passes;

    public ManagerDao(){
        users = new ArrayList<String>();
        passes = new ArrayList<String>();

        users.add("iceNightManager");
        passes.add("iceNight123");
        users.add("youzi");
        passes.add("iceNight123");
        users.add("hezi");
        passes.add("iceNight123");
    }

    public boolean checkManager(String user,String pass){
        for(int i=0;i<users.size();i++){
            if(users.get(i).equals(user)){
                if(passes.get(i).equals(pass)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
