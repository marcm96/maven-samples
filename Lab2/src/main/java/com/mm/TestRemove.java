package com.mm;

import com.mm.repository.Order;
import com.mm.states.RepoState;
import com.mm.states.SizeState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 20, time = 1)
@Fork(2)
public class TestRemove {

    @State(Scope.Benchmark)
    public static class AfterState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepoState repoState) {
            repoState.orders.add(order);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepoState repoState) {
            repoState.orders.add(order);
        }
    }

    @Benchmark
    public boolean remove_existing(RepoState repoState, TestRemove.ExistingState existing) {
        return repoState.orders.remove(existing.order);
    }

    @Benchmark
    public boolean remove_after(RepoState repoState, TestRemove.AfterState after) {
        return repoState.orders.remove(after.order);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestAdd.class.getSimpleName() + ".*")
                .build();

        new Runner(opt).run();
    }
}
