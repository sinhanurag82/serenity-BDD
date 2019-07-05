package com.sinha.serenity.tasks;

import com.sinha.serenity.ui.SearchBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class PlanTravel implements Task {
    private final String travelFrom;
    private final String travelTo;

    protected PlanTravel(String travelFrom, String travelTo) {
        this.travelFrom = travelFrom;
        this.travelTo = travelTo;
    }

    public static PlanTravel between(String travelFrom, String travelTo) {
        return instrumented(PlanTravel.class, travelFrom, travelTo);
    }

    @Override
    @Step ("search for travel between #travelFrom and #travelTo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(travelFrom).into(SearchBox.SEARCH_FIELD_TRAVEL_FROM)
        );

        actor.attemptsTo(
                Enter.theValue(travelTo).into(SearchBox.SEARCH_FIELD_TRAVEL_TO).thenHit(ENTER)
        );
    }
}
