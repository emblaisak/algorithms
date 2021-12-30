package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

public class SortCheckerImpTest extends SortCheckerTestTemplate {
    @Override
    protected SortChecker getNewInstance() {
        return new SortCheckerImp();
    }
}
