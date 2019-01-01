package com.ss.business.service;

import java.util.Arrays;

import com.ss.business.model.Result;
import com.ss.business.model.User;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;

/**
 * DroolsService
 */
@Service
public class DroolsService {

    @KSession("session1")
    private StatelessKieSession session1;

    @KSession("session2")
    private StatelessKieSession session2;

    public Result<Void> greetUser(User user) {
        Result<Void> result = new Result<>();
        if(user.getName() != null && (user.getName().startsWith("1") || user.getName().startsWith("4"))) {
            session2.execute(Arrays.asList(new Object[] {user, result}));
        } else {
            session1.execute(Arrays.asList(new Object[] {user, result}));
        }
        return result;
    }

    /*public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieContainerSessionsPool pool = kc.newKieSessionsPool(10);
        KieSession ksession = pool.newKieSession();

        final User user = new User();
        user.setName("abc");
        ksession.insert(user);

        final User user2 = new User();
        user2.setName("xyz");
        ksession.insert(user2);

        ksession.fireAllRules();
        ksession.dispose();
    }*/
}