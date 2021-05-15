package com.cursodev.hrworker.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
