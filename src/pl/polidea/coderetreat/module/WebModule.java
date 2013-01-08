package pl.polidea.coderetreat.module;

import com.google.inject.AbstractModule;
import pl.polidea.coderetreat.web.WebInterface;
import pl.polidea.coderetreat.web.WebInterfaceImpl;

public class WebModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebInterface.class).to(WebInterfaceImpl.class);
    }

}
