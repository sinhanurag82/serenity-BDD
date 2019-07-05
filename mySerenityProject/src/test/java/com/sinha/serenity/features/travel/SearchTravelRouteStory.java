package com.sinha.serenity.features.travel;

import com.sinha.serenity.tasks.OpenTravelApplication;
import com.sinha.serenity.tasks.PlanTravel;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityRunner.class)
public class SearchTravelRouteStory {

    Actor traveller = Actor.named("Traveller");


    @Managed(driver = "chrome", uniqueSession=true, clearCookies=Never)
    WebDriver browser;

    @Steps
    OpenTravelApplication openTravelApplication;

    @Before
    public void travellerCanBrowseTheWeb() {
        traveller.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void search_results_should_show_route_options() {
        givenThat(traveller).wasAbleTo(openTravelApplication);

        when(traveller).attemptsTo(PlanTravel.between("canary wharf", "pinner"));

        then(traveller).should(eventually(seeThat(TheWebPage.title(), containsString("Journey results"))));
    }
}
