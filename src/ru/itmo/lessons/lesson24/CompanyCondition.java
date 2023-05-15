package ru.itmo.lessons.lesson24;

import java.io.Serializable;
import java.util.function.Predicate;

public interface CompanyCondition extends Serializable, Predicate<Manager> {
}
