package com.sinha.serenity.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.name("q"));
    public static Target SEARCH_FIELD_TRAVEL_FROM = Target.the("travel from").located(By.id("InputFrom"));
    public static Target SEARCH_FIELD_TRAVEL_TO = Target.the("travel to").located(By.id("InputTo"));
}
