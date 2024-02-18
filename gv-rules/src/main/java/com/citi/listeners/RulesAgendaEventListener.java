package com.citi.listeners;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.drools.core.event.DefaultAgendaEventListener;

public class RulesAgendaEventListener extends DefaultAgendaEventListener {

    public RulesAgendaEventListener() {
        super();
    }

    /**
     * Log the name of the rules that have got fired
     */
    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        System.out.println(":: After Rule Match fired: {} " +
                event.getMatch().getRule().getName());
        // event.getMatch().getObjects().forEach(System.out::println);
    }

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        System.out.println(":: Before Rule match fired: {} " +
                event.getMatch().getRule().getName());
    }

    @Override
    public void matchCreated(MatchCreatedEvent event) {
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println(":: Match created event: {} " +
                event.getMatch().getRule().getName());
        event.getMatch().getObjects().forEach(System.out::println);

    }
}
