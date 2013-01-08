package pl.polidea.coderetreat.module;

import com.google.inject.AbstractModule;
import pl.polidea.coderetreat.tasks.ProductionTaskExecutor;
import pl.polidea.coderetreat.tasks.TaskExecutorInterface;

public class TaskExecutorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TaskExecutorInterface.class).to(ProductionTaskExecutor.class);
    }
}