package com.natsu.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author shuaishuai.ren
 * @since 2020-10-30
 */
public class Builder<T> {
    private final Supplier<T> instantiator;
    private final List<Consumer<T>> modifiers = new ArrayList<>();

    private Builder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> Builder<T> of(Supplier<T> instantiator) {
        return new Builder<>(instantiator);
    }

    public <V> Builder<T> with(BiConsumer<T, V> consumer, V v) {
        Consumer<T> c = (T t) -> consumer.accept(t, v);
        modifiers.add(c);
        return this;
    }

    public T build() {
        final T t = instantiator.get();
        modifiers.forEach((Consumer<T> consumer) -> consumer.accept(t));
        return t;
    }
}
