package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;

public abstract class Parser {
    public abstract Composite parse(Composite composite, String text) throws HandlerException;
}
