package com.sinha.serenity.tasks;

import com.sinha.serenity.ui.TravelForLondonPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTravelApplication implements Task {

    TravelForLondonPage travelForLondonPage;

    @Override
    @Step("Open tfl travel website")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(travelForLondonPage));
    }
}
