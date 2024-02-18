package com.citi.listeners;

import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;


public class RulesRuntimeEventListener extends DebugRuleRuntimeEventListener {

    public RulesRuntimeEventListener() {
        super();
    }

    /**
     * Log the fact insertion event with the full fact details
     */
    public void objectInserted(ObjectInsertedEvent event) {
        System.out.println("Inserted fact is of " + event.getObject().getClass().toString());
    }

    /**
     * Log the fact update event with the full fact details
     */
    public void objectUpdated(ObjectUpdatedEvent event) {
        // intentionally left blank as this event should not be logged
    }

    public void objectDeleted(ObjectDeletedEvent event) {
        // intentionally left blank as this event should not be logged
    }
}
