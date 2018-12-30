package com.ss.business.service;

import com.ss.business.model.Result;
import com.ss.business.model.User;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.stereotype.Service;

/**
 * DroolsService
 */
@Service
public class DroolsService {

    @KSession("appKSession")
    private KieSession appKSession;

    public Result<Void> greetUser(User user) {
        Result<Void> result = new Result<>();
        FactHandle fu = appKSession.insert(user);
        FactHandle fr = appKSession.insert(result);
        appKSession.fireAllRules();
        appKSession.delete(fu);
        appKSession.delete(fr);
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