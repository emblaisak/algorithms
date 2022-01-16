package org.pg4200.ex06;

public class ImmutableBookAndAuthorTest extends ImmutableBookAndAuthorTestTemplate {
    @Override
    protected ImmutableBook getNewEmptyInstanceOfBook() {
        return new ImmutableBookImp();
    }

    @Override
    protected ImmutableAuthor getNewEmptyInstanceOfAuthor() {
        return new ImmutableAuthorImp();
    }
}
